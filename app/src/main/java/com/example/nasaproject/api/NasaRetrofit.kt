package com.example.nasaproject.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NasaRetrofit
{
    @Volatile
    private var Nasa_Retrofit: Retrofit? = null
    private var url : String = "https://api.nasa.gov"
    private var apiKey : String = "CNfWSW0fpsfngOb7JILT4vULeeL2sO4DIZGeB83z"

    fun getNasaClient() : Retrofit {
        return Nasa_Retrofit ?: synchronized(this) {
            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder()
                    .build()
            val retrofit = Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
            Nasa_Retrofit = retrofit
            retrofit
        }
    }

    fun<T> getNasaServices(service: Class<T>): T {
        return getNasaClient().create(service)
    }
}