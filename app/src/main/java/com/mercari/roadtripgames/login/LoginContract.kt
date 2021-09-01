package com.mercari.roadtripgames.login

import androidx.lifecycle.LiveData
import com.mercari.roadtripgames.user.User

interface LoginContract {
    interface Navigator {
        fun login(user: User)
        fun signup()
        fun openHomeWithoutLogin()
    }

    interface Repository {
        fun getUser(username: String, password: String): LiveData<User?>
    }
}