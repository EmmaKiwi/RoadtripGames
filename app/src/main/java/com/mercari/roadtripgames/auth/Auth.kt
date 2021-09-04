package com.mercari.roadtripgames.auth

import com.mercari.roadtripgames.user.User
import dagger.Reusable
import javax.inject.Inject

interface Auth {
    fun setUser(user: User)
    fun getUser(): User?
}

@Reusable
class AuthImpl @Inject constructor() : Auth {

    private var user: User? = null

    override fun getUser(): User? {
        return user
    }

    override fun setUser(newUser: User) {
        user = newUser
    }
}