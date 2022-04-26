package com.example.nasaproject.repository


import com.example.nasaproject.api.NasaInterface
import com.example.nasaproject.api.NasaRetrofit
import com.example.nasaproject.model.Nasa_model
import retrofit2.Response

class NasaRepository() {
    suspend fun getFlower(): Response<List<Nasa_model>> {
        return NasaRetrofit.getNasaServices(NasaInterface::class.java).getNasaList()
    }
}