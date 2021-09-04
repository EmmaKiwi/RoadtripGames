package com.mercari.roadtripgames.login

import com.mercari.roadtripgames.user.User

interface LoginContract {
    interface Navigator {
        fun login(user: User)
        fun signup()
        fun openHomeWithoutLogin()
    }

    interface Repository {
       suspend  fun getUser(username: String, password: String): User?
    }
}