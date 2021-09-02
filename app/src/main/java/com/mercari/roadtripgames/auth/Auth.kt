package com.mercari.roadtripgames.auth

import com.mercari.roadtripgames.user.User
import javax.inject.Inject

interface Auth {
    fun setUser(user: User)
    fun getUser(): User?
}

class AuthImpl @Inject constructor() : Auth {

    private var user: User? = null

    override fun getUser(): User? {
        return user
    }

    override fun setUser(newUser: User) {
        user = newUser
    }
}