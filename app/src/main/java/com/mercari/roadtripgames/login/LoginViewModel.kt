package com.mercari.roadtripgames.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mercari.roadtripgames.auth.Auth
import com.mercari.roadtripgames.auth.user.PasswordManager
import com.mercari.roadtripgames.auth.user.User
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val loginRepository: LoginContract.Repository,
    private val passwordManager: PasswordManager,
    private val auth: Auth
) : ViewModel() {

    val passwordValidationError = MutableLiveData<Boolean>()
    val usernameValidationError = MutableLiveData<Boolean>()

    val user = MutableLiveData<User>()

    val userNotFoundError = MutableLiveData<Boolean>()

    fun onSignupReturn() {
        auth.getUser()?.let { user.postValue(it) }
    }

    fun login(username: String, password: String) {
        if (username.isBlank() || password.isBlank()) {
            usernameValidationError.postValue(username.isBlank())
            passwordValidationError.postValue(password.isBlank())
        }
        val hashedPassword = passwordManager.getPasswordHash(password)
        viewModelScope.launch {
            val existingUser = loginRepository.getUser(username, hashedPassword)
            existingUser?.let {
                auth.setUser(it)
                user.postValue(it)
            } ?: userNotFoundError.postValue(true)
        }
    }
}