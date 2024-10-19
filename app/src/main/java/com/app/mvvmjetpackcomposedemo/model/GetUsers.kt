package com.app.mvvmjetpackcomposedemo.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class GetUsers(
    @SerializedName("data")
    val data: List<Data>?,
    @SerializedName("page")
    val page: Int?,
    @SerializedName("per_page")
    val perPage: Int?,
    @SerializedName("total")
    val total: Int?,
    @SerializedName("total_pages")
    val totalPages: Int?
)
data class Data(
    @SerializedName("avatar")
    val avatar: String?,
    @SerializedName("email")
    val email: String?,
    @SerializedName("first_name")
    val firstName: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("last_name")
    val lastName: String?
):Serializable