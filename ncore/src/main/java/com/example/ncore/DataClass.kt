package com.example.ncore

import com.google.gson.annotations.SerializedName

data class DataClass(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("userId") val userId: Int
)