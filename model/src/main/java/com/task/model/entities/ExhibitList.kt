package com.task.model.entities

import com.google.gson.annotations.SerializedName

data class ExhibitList(
    @SerializedName("list") val list: List<Exhibit>
)