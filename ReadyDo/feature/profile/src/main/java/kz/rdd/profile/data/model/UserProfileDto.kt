package kz.rdd.profile.data.model

import com.google.gson.annotations.SerializedName

data class UserProfileDto (
    @SerializedName("id") val id: Int,
    @SerializedName("username") val username: String?,
    @SerializedName("email") val email: String?,
    @SerializedName("grade") val grade: String?,
    @SerializedName("address") val address: String?,
    @SerializedName("about_yourself") val aboutYourself: String?,
    @SerializedName("phone_number") val phoneNumber: String?,
)

data class RequestProfile(
    val firstName: String,
    val lastName: String,
    val avatar: String?,
    val email: String,
    val aboutMySelf: String,
    val address: String,
    val phoneNumber: String,
)