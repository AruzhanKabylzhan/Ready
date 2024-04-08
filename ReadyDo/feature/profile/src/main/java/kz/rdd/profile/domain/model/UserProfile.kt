package kz.rdd.profile.domain.model

import com.google.gson.annotations.SerializedName

data class UserProfile (
    val id: Int,
    val username: String,
    val email: String,
    val grade: String,
    val address: String,
    val aboutYourself: String,
    val phoneNumber: String,
)