package com.mercari.roadtripgames.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mercari.roadtripgames.auth.Auth
import com.mercari.roadtripgames.auth.user.User
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val auth: Auth
): ViewModel() {

    val user = MutableLiveData<User>()
    val isGuest = MutableLiveData<Boolean>()

    init {
        auth.getUser()?.let { user.postValue(it) }
            ?: isGuest.postValue(true)
    }
}