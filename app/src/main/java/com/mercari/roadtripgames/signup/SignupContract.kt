package com.mercari.roadtripgames.signup

import com.mercari.roadtripgames.user.User

interface SignupContract {

    interface Repository {
        suspend fun createUser(user: User): Long
        suspend fun getUserByName(username: String): User?
    }

    interface Navigator {
        fun signup(user: User)
    }
}