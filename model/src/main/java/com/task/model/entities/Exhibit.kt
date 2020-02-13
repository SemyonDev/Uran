package com.task.model.entities

import com.google.gson.annotations.SerializedName

data class Exhibit(
    @SerializedName("title") val title:String,
    @SerializedName("images") val images:List<String>)