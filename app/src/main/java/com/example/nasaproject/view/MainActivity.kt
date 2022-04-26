package com.example.nasaproject.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nasaproject.R
import com.example.nasaproject.adapter.NasaAdapter
import com.example.nasaproject.adapter.NasaClick
import com.example.nasaproject.databinding.ActivityMainBinding
import com.example.nasaproject.model.Nasa_model
import com.example.nasaproject.viewmodel.NasaViewmodel


class MainActivity : AppCompatActivity(), NasaListener {
    private var nasaAdapter: NasaAdapter? = null
    private val viewModel by lazy {
        ViewModelProvider(this).get(NasaViewmodel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.setLifecycleOwner(this)
        binding.nasaViewModel = viewModel
        viewModel.nasaListener = this

        nasaAdapter = NasaAdapter(NasaClick {
            viewModel.displayNasaToast(it)
        })

        binding.FlowerRecyclerview.apply {
            layoutManager = LinearLayoutManager(this.context, RecyclerView.VERTICAL, false)
            adapter = nasaAdapter
        }

        viewModel.nasaList?.observe(this,
                {
                    cakesList ->
                    cakesList?.apply {
                        nasaAdapter?.nasaList = this
                    }
                })
    }

    override fun onFailure(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun onItemClick(nasaModel: Nasa_model) {
        Toast.makeText(this, nasaModel.title, Toast.LENGTH_LONG).show()
    }
}