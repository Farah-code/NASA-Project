package com.example.nasaproject.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView;
import com.example.nasaproject.R
import com.example.nasaproject.databinding.NasaViewBinding
import com.example.nasaproject.model.Nasa_model

class NasaAdapter(val nasaListener: NasaClick): RecyclerView.Adapter<NasaViewHolder>()  {

        var nasaList: List<Nasa_model> = emptyList()
        set(value) {
                field = value
                notifyDataSetChanged()
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NasaViewHolder {
                val withDataBinding: NasaViewBinding = DataBindingUtil.inflate(

                        LayoutInflater.from(parent.context),

                        NasaViewHolder.LAYOUT,

                        parent,
                        false
                )
                return NasaViewHolder(withDataBinding)
        }

        override fun onBindViewHolder(holder: NasaViewHolder, position: Int) {
                holder.viewDatabinding.also {
                        it.nasaModels = nasaList[position]
                        it.nasaClickBack = nasaListener
                }
        }

        override fun getItemCount(): Int {
                return nasaList.size
        }
}

class NasaViewHolder(val viewDatabinding: NasaViewBinding): RecyclerView.ViewHolder(viewDatabinding.root) {
        companion object {
                @LayoutRes
                val LAYOUT = R.layout.nasa_view
        }
}

class NasaClick(val block: (Nasa_model)->Unit) {
        fun onClick(nasa: Nasa_model) = block(nasa)
}