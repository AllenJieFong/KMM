package data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BaseResponse<T>(
    val metadata: Metadata? = null,
    @SerialName("data") val data: T? = null
)

@Serializable
data class Metadata(
    val desc: String,
    val status: String
)