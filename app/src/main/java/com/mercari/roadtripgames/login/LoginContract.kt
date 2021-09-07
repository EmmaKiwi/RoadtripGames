package com.mercari.roadtripgames.login

import com.mercari.roadtripgames.auth.user.User

interface LoginContract {
    interface Navigator {
        fun login()
        fun signup()
        fun openHomeWithoutLogin()
    }

    interface Repository {
       suspend fun getUser(username: String, password: String): User?
       suspend fun getUserById(userId: Long): User?
    }
}