package com.jclavijo.picoplaca.core.model

data class Vehicle(
    val id: Long = 0,
    val plate: String,
    val isActive: Boolean = true
)
