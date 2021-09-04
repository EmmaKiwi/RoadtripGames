package com.mercari.roadtripgames.login

import com.mercari.roadtripgames.database.AppDatabase
import javax.inject.Inject

class LoginRepository @Inject constructor(
    private val database: AppDatabase
) : LoginContract.Repository {

    override suspend fun getUser(username: String, password: String) =
        database.userDao().getUser(username, password)
}