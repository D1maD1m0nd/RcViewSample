package com.example.rcviewsample.model

import java.util.*

data class User(
    val id : UUID = UUID.randomUUID(),
    val name : String,
    val age : Int,
    val active : Boolean
)

