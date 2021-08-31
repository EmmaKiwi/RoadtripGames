package com.mercari.roadtripgames.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mercari.roadtripgames.R
import com.mercari.roadtripgames.login.di.DaggerLoginComponent
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

class LoginActivity: AppCompatActivity() {

    @Inject
    lateinit var navigator: LoginContract.Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        setupDi()
        setupListeners()
    }

    private fun setupDi() {
        DaggerLoginComponent.builder()
            .activity(this)
            .build()
            .inject(this)
    }

    private fun setupListeners() {
        login_button.setOnClickListener {
            navigator.login()
        }
    }
}
