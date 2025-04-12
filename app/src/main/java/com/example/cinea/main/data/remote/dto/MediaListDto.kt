package com.example.cinea.main.data.remote.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MediaListDto(
    @SerialName("page")
    val page: Int? = null,
    @SerialName("results")
    val result: List<MediaDto>? = null
)