package com.mercari.roadtripgames.signup

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mercari.roadtripgames.auth.Auth
import com.mercari.roadtripgames.user.User
import kotlinx.coroutines.launch
import javax.inject.Inject

class SignupViewModel @Inject constructor(
    private val repository: SignupContract.Repository,
    private val auth: Auth
) : ViewModel() {

    val usernameValidation = MutableLiveData<String>()
    val passwordValidation = MutableLiveData<String>()

    val user = MutableLiveData<User>()

    fun createUser(
        username: String,
        password: String,
        confirmPassword: String
    ) {
        when {
            username.isBlank() -> {
                usernameValidation.postValue("Please enter a username")
            }
            password.count() <= MIN_PASSWORD_LENGTH -> {
                passwordValidation.postValue("Your password must be at least $MIN_PASSWORD_LENGTH characters long")
            }
            password != confirmPassword -> {
                passwordValidation.postValue("Your password confirmation does not match")
            }
            else -> {
                viewModelScope.launch {
                    val newUser = User(username = username, password = password)
                    val id = repository.createUser(newUser)
                    auth.setUser(newUser)
                    user.postValue(newUser.copy(id = id))
                }
            }
        }
    }

    companion object {
        private const val MIN_PASSWORD_LENGTH = 5
    }
}