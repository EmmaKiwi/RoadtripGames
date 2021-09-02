package com.mercari.roadtripgames.signup

import com.mercari.roadtripgames.user.User

interface SignupContract {

    interface Repository {
        suspend fun createUser(user: User): Long
    }

    interface Navigator {
        fun signup(user: User)
    }
}