package com.example.myapplication.network

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
@Parcelize
data class Wellsitems (
    @SerializedName("api") val api : Long,
    @SerializedName("name") val name : String,
    @SerializedName("location") val location : String
) : Parcelable

data class WellsitemsList (
    @SerializedName("wellsites") val wellsites : List<Wellsitems>
)