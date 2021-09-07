package com.mercari.roadtripgames.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mercari.roadtripgames.auth.Auth
import com.mercari.roadtripgames.auth.user.PasswordManager
import com.mercari.roadtripgames.auth.user.User
import com.mercari.roadtripgames.utils.SharedPreferenceManager
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val loginRepository: LoginContract.Repository,
    private val passwordManager: PasswordManager,
    private val auth: Auth,
    private val preferenceManager: SharedPreferenceManager
) : ViewModel() {

    val passwordValidationError = MutableLiveData<Boolean>()
    val usernameValidationError = MutableLiveData<Boolean>()

    val user = MutableLiveData<User>()

    val userNotFoundError = MutableLiveData<Boolean>()
    private var shouldStayLoggedIn: Boolean = false

    init {
        preferenceManager.getPreference(USER_KEY).takeIf { it != 0L }?.let { userId ->
            viewModelScope.launch {
                loginRepository.getUserById(userId)?.let {
                    auth.setUser(it)
                    user.postValue(it)
                }
            }
        }
    }

    fun onSignupReturn() {
        auth.getUser()?.let { user.postValue(it) }
    }

    fun onStayLoggedInChecked(stayLoggedIn: Boolean) {
        shouldStayLoggedIn = stayLoggedIn
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
                if (shouldStayLoggedIn) {
                    saveUser(it.id)
                }
                auth.setUser(it)
                user.postValue(it)
            } ?: userNotFoundError.postValue(true)
        }
    }

    private fun saveUser(userId: Long) {
        preferenceManager.savePreference(USER_KEY, userId)
    }

    companion object {
        private const val USER_KEY = "current_user"
    }
}