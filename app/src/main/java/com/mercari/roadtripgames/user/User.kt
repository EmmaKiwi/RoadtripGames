package com.mercari.roadtripgames.user

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey
    val id: String,
    @ColumnInfo
    val username: String,
    @ColumnInfo
    val password: String
)