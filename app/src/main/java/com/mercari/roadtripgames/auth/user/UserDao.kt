package com.mercari.roadtripgames.auth.user

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {

    @Query("SELECT * from user WHERE id = :id")
    suspend fun getUserById(id: Long): User?

    @Query("SELECT * from user WHERE username = :username AND password = :passwordHash")
    suspend fun getUser(username: String, passwordHash: String): User?

    @Query("SELECT * from user WHERE username = :username")
    suspend fun getUserByName(username: String): User?


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: User): Long
}