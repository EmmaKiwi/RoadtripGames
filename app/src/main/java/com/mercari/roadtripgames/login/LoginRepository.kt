package com.mercari.roadtripgames.login

import com.mercari.roadtripgames.auth.user.User
import com.mercari.roadtripgames.database.AppDatabase
import javax.inject.Inject

class LoginRepository @Inject constructor(
    private val database: AppDatabase
) : LoginContract.Repository {

    override suspend fun getUser(username: String, password: String) =
        database.userDao().getUser(username, password)

    override suspend fun getUserById(userId: Long): User? =
        database.userDao().getUserById(userId)
}