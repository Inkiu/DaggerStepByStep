package com.example.daggerstepbystep.model

data class User(
    val id: Long = 0,
    val name: String,
    val address: String,
    val createdAt: String = "",
    val updatedAt: String = ""
)