package com.mercari.roadtripgames.user

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query

@Dao
interface UserDao {

    @Query("SELECT * from user WHERE id = :id")
    fun getUserById(id: String): LiveData<User>

    @Query("SELECT * from user WHERE username = :username AND password = :passwordHash")
    fun getUser(username: String, passwordHash: String): LiveData<User?>
}