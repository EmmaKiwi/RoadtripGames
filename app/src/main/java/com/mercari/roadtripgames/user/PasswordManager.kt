package com.mercari.roadtripgames.user

import java.nio.charset.StandardCharsets.UTF_8
import java.security.MessageDigest
import javax.inject.Inject

class PasswordManager @Inject constructor() {

    fun getPasswordHash(password: String): String {
        val digest = MessageDigest.getInstance("SHA-256").digest(password.toByteArray(UTF_8))
        return digest.toString()
    }
}