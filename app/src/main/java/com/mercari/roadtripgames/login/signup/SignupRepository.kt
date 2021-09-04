package com.mercari.roadtripgames.login.signup

import com.mercari.roadtripgames.database.AppDatabase
import com.mercari.roadtripgames.auth.user.User
import javax.inject.Inject

class SignupRepository @Inject constructor(
    private val database: AppDatabase
) : SignupContract.Repository {

    override suspend fun createUser(user: User) = database.userDao().addUser(user)

    override suspend fun getUserByName(username: String): User? =
        database.userDao().getUserByName(username)
}