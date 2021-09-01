package com.mercari.roadtripgames.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mercari.roadtripgames.user.PasswordManager
import com.mercari.roadtripgames.user.User
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val loginRepository: LoginContract.Repository,
    private val passwordManager: PasswordManager
) : ViewModel() {

    val passwordValidationError = MutableLiveData<Boolean>()
    val usernameValidationError = MutableLiveData<Boolean>()

    fun getUser(username: String, password: String): LiveData<User?> {
        if (username.isBlank() || password.isBlank()) {
            usernameValidationError.postValue(username.isBlank())
            passwordValidationError.postValue(password.isBlank())
        }
        val hashedPassword = passwordManager.getPasswordHash(password)
        return loginRepository.getUser(username, hashedPassword)
    }
}