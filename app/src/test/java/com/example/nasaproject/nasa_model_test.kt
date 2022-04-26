package com.example.nasaproject

import com.example.nasaproject.model.Nasa_model
import org.junit.Test


class nasa_model_test
{
    lateinit var nasaModel : Nasa_model

    @Test
    fun nasa_model() {
        val data = nasaModel.date
        val explanation = nasaModel.explanation
        val media_type =  nasaModel.media_type
        val service_version =  nasaModel.service_version
        val title =  nasaModel.title
        val url =  nasaModel.url

        assert(data.equals("01.29.2020"))
        assert(explanation.equals(""))
        assert(media_type.equals(""))
        assert(service_version.equals(""))
        assert(title.equals(""))
        assert(url.equals(""))
        
    }
}
