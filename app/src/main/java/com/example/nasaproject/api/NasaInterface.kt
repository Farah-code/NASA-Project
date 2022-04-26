package com.example.nasaproject.api

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.example.nasaproject.model.Nasa_model
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


const val API_KEY  = "CNfWSW0fpsfngOb7JILT4vULeeL2sO4DIZGeB83z"

// https://api.nasa.gov/planetary/apod?api_key=CNfWSW0fpsfngOb7JILT4vULeeL2sO4DIZGeB83z

interface NasaInterface {

    @GET("/planetary/apod?")
    suspend fun getNasaList(): Deferred<List<Nasa_model>>

    companion object {
        operator fun invoke(): NasaInterface {
            val requestInterceptor = Interceptor { chain ->

                val url = chain.request()
                    .url
                    .newBuilder()
                    .addQueryParameter("key", API_KEY)
                    .build()

                val request = chain.request()
                    .newBuilder()
                    .url(url)
                    .build()

                return@Interceptor chain.proceed(request)

            }

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .build()

            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("https://api.nasa.gov")
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(NasaInterface::class.java)
        }
    }
}

/*
    @GET("/planetary/apod?")
    suspend fun getNasaList1(): Response<List<Nasa_model>>

    @GET("/planetary/apod?")
    suspend fun getNasaList2() : Observable<List<Nasa_model>>
*/

