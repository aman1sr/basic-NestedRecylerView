package com.aman.basearchsetup.model.got


import com.google.gson.annotations.SerializedName

data class Member(
    @SerializedName("name")
    val name: String?,
    @SerializedName("slug")
    val slug: String?
)