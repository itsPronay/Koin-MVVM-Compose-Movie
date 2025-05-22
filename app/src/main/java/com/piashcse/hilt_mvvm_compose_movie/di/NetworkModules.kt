package com.piashcse.hilt_mvvm_compose_movie.di

import com.piashcse.hilt_mvvm_compose_movie.data.datasource.remote.ApiService
import com.piashcse.hilt_mvvm_compose_movie.data.datasource.remote.ApiURL
import com.piashcse.hilt_mvvm_compose_movie.network.ApiKeyInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val NetworkModule = module {

    single<String> { ApiURL.BASE_URL }

    single<HttpLoggingInterceptor> {
        HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    single<ApiKeyInterceptor> { ApiKeyInterceptor() }

    single<Converter.Factory> { GsonConverterFactory.create() }

    single<ApiService> { get<Retrofit>().create(ApiService::class.java) }

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(get<String>())
            .client(get<OkHttpClient>())
            .addConverterFactory(get<Converter.Factory>())
            .build()
    }

    single {
        OkHttpClient().newBuilder()
            .callTimeout(40, TimeUnit.SECONDS)
            .connectTimeout(40, TimeUnit.SECONDS)
            .readTimeout(40, TimeUnit.SECONDS)
            .writeTimeout(40, TimeUnit.SECONDS)
            .addInterceptor(get<HttpLoggingInterceptor>())
            .addInterceptor(get<ApiKeyInterceptor>())
            .build()
    }
}
//
//@Module
//@InstallIn(SingletonComponent::class)
//object NetworkModules {
//    /**
//     * Provides BaseUrl as string
//     */
//    @Singleton
//    @Provides
//    fun provideBaseURL(): String {
//        return ApiURL.BASE_URL
//    }
//
//    /**
//     * Provides LoggingInterceptor for api information
//     */
//    @Singleton
//    @Provides
//    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
//        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
//    }
//
//    /**
//     * Provides API Key Interceptor
//     */
//    @Singleton
//    @Provides
//    fun provideApiKeyInterceptor(): ApiKeyInterceptor {
//        return ApiKeyInterceptor()
//    }
//
//    /**
//     * Provides custom OkkHttp
//     */
//    @Singleton
//    @Provides
//    fun provideOkHttpClient(
//        loggingInterceptor: HttpLoggingInterceptor,
//        apiKeyInterceptor: ApiKeyInterceptor,
//    ): OkHttpClient {
//        val okHttpClient = OkHttpClient().newBuilder()
//
//        okHttpClient.callTimeout(40, TimeUnit.SECONDS)
//        okHttpClient.connectTimeout(40, TimeUnit.SECONDS)
//        okHttpClient.readTimeout(40, TimeUnit.SECONDS)
//        okHttpClient.writeTimeout(40, TimeUnit.SECONDS)
//        okHttpClient.addInterceptor(loggingInterceptor)
//        okHttpClient.addInterceptor(apiKeyInterceptor)
//        okHttpClient.build()
//        return okHttpClient.build()
//    }
//
//    /**
//     * Provides converter factory for retrofit
//     */
//    @Singleton
//    @Provides
//    fun provideConverterFactory(): Converter.Factory {
//        return GsonConverterFactory.create()
//    }
//
//    /**
//     * Provides ApiServices client for Retrofit
//     */
//    @Singleton
//    @Provides
//    fun provideRetrofitClient(
//        baseUrl: String,
//        okHttpClient: OkHttpClient,
//        converterFactory: Converter.Factory,
//    ): Retrofit {
//        return Retrofit.Builder()
//            .baseUrl(baseUrl)
//            .client(okHttpClient)
//            .addConverterFactory(converterFactory)
//            .build()
//    }
//
//    /**
//     * Provides Api Service using retrofit
//     */
//    @Singleton
//    @Provides
//    fun provideRestApiService(retrofit: Retrofit): ApiService {
//        return retrofit.create(ApiService::class.java)
//    }
//
//
//    // ApiService from Retrofit instance (no singleOf, because of create method)
//    single
//    {
//        get<Retrofit>().create(ApiService::class.java)
//    }
//
//}
//
//val networkModule = module {
//
//    // Provide Base URL string (no constructor, so singleOf not used here)
//    single<String> { ApiURL.BASE_URL }
//
//    // Logging interceptor
//    singleOf(::HttpLoggingInterceptor).bind<HttpLoggingInterceptor>().also {
//        it.get().apply { level = HttpLoggingInterceptor.Level.BODY }
//    }
//    // However, setting level inside singleOf is tricky, so better to do it like this:
//    single {
//        HttpLoggingInterceptor().apply {
//            level = HttpLoggingInterceptor.Level.BODY
//        }
//    }
//
//    // ApiKeyInterceptor can be constructed simply
//    singleOf(::ApiKeyInterceptor)
//
//    // OkHttpClient needs builder calls, so singleOf can't be used here
//    single {
//        OkHttpClient.Builder()
//            .callTimeout(40, TimeUnit.SECONDS)
//            .connectTimeout(40, TimeUnit.SECONDS)
//            .readTimeout(40, TimeUnit.SECONDS)
//            .writeTimeout(40, TimeUnit.SECONDS)
//            .addInterceptor(get<HttpLoggingInterceptor>())
//            .addInterceptor(get<ApiKeyInterceptor>())
//            .build()
//    }
//
//    // GsonConverterFactory can be created via singleOf
//    singleOf(::GsonConverterFactory.create).bind<Converter.Factory>()
//
//    // Retrofit requires parameters so no singleOf
//    single {
//        Retrofit.Builder()
//            .baseUrl(get<String>())
//            .client(get())
//            .addConverterFactory(get())
//            .build()
//    }
//
//}
