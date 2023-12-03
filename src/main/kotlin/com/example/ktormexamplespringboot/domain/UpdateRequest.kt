package com.example.ktormexamplespringboot.domain

data class UpdateRequest(
    val id: Int,
    val name: String,
    val location: String,
)
