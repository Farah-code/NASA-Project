package com.example.nasaproject.view

import com.example.nasaproject.model.Nasa_model


interface NasaListener {
    fun onItemClick(flowerModel: Nasa_model)
    fun onFailure(message: String)
}