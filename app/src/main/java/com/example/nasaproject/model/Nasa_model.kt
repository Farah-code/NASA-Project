package com.example.nasaproject.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Nasa_model(

    @SerializedName("date")
    @Expose
    var date : String,

    @SerializedName("explanation")
    @Expose
    var explanation : String,

    @SerializedName("media_type")
    @Expose
    var media_type : String,

    @SerializedName("service_version")
    @Expose
    var service_version: String,

    @SerializedName("title")
    @Expose
    var title : String,

    @SerializedName("url")
    @Expose
    var url : String

) : Parcelable
{
    fun getdate () : String
    {
        return date
    }

    fun getexplanation() : String
    {
        return explanation
    }

    fun getmedia_type () : String
    {
        return media_type
    }

    fun getservice_version () : String
    {
        return service_version
    }

    fun get_Title () : String
    {
        return title

    }

    fun get_url () : String
    {
        return url
    }

}

