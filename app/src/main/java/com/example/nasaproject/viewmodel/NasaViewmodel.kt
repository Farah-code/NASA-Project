package com.example.nasaproject.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nasaproject.model.Nasa_model
import com.example.nasaproject.repository.NasaRepository
import com.example.nasaproject.util.NasaCoroutines
import com.example.nasaproject.view.NasaListener


class NasaViewmodel: ViewModel() {
    var nasaList = MutableLiveData<List<Nasa_model>>()
    var nasaListener: NasaListener? = null

    init {
        refreshList()
    }

    fun refreshList() {


        NasaCoroutines.main {
            val flowerResponse = NasaRepository().getFlower()
            if (flowerResponse.isSuccessful) {
                flowerResponse.body()?.let {
                    //this is where we add or change the mutable livedata value
                    nasaList?.value = it
                    Log.d("flower_list", nasaList.toString())
                }
            } else {
                nasaListener?.onFailure(flowerResponse.message())
            }
        }
    }

    fun displayNasaToast(nasaModel: Nasa_model) {
        nasaListener?.onItemClick(nasaModel)
    }
}