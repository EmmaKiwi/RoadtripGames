package com.mercari.roadtripgames.auth.user

import java.nio.charset.StandardCharsets.UTF_8
import java.security.MessageDigest
import javax.inject.Inject


class PasswordManager @Inject constructor() {

    fun getPasswordHash(password: String): String {
        val digest = MessageDigest.getInstance("SHA-256").digest(password.toByteArray(UTF_8))
        val sb = StringBuilder()
        for (element in digest) {
            sb.append(((element.toInt() and 0xff) + 0x100).toString(16).substring(1))
        }
        return sb.toString()
    }
}