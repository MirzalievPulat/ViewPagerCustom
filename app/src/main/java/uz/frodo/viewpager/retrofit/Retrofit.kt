package uz.frodo.viewpager.retrofit

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object Retrofit {

    private val logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    private val headerInterceptor = Interceptor { chain ->
        val request = chain.request().newBuilder()
            .addHeader("Authorization","Client-ID E7FfktuF5GbAzi1myW0u74420Y0rJvGQUVMhZnJhM2E")
            .build()
        chain.proceed(request)
    }

    private val okHttp = OkHttpClient.Builder().addInterceptor(headerInterceptor).addInterceptor(logger).build()

    private val retrofit = Retrofit.Builder().baseUrl("https://api.unsplash.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttp)
        .build()

    fun<T> getRetrofit(service: Class<T>):T{
        return retrofit.create(service)
    }
}