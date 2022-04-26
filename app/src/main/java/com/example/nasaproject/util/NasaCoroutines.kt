package com.example.nasaproject.util

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

object NasaCoroutines {
    fun main(Nasa: suspend (()->Unit)) {

        CoroutineScope(Dispatchers.Main).launch {

            Nasa()
        }
    }
}