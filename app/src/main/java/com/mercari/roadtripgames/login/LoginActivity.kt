package com.mercari.roadtripgames.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.mercari.roadtripgames.R
import com.mercari.roadtripgames.RoadTripApplication
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

class LoginActivity: AppCompatActivity() {

    @Inject
    lateinit var navigator: LoginContract.Navigator

    @Inject
    lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        setupDi()
        setupOnClickListeners()
        setupValidation()
    }

    private fun setupDi() {
        (this.application as RoadTripApplication)
            .appComponent
            .newLoginComponent()
            .activity(this)
            .build()
            .inject(this)
    }

    private fun setupValidation() {
        viewModel.usernameValidationError.observe(this, Observer { isError ->
            if (isError) {
                username.error = getString(R.string.username_error)
            }
        })
        viewModel.passwordValidationError.observe(this, Observer { isError ->
            if (isError) {
                password.error = getString(R.string.password_error)
            }
        })
    }

    private fun setupOnClickListeners() {
        login_button.setOnClickListener { login() }
        skip_button.setOnClickListener {
            navigator.openHomeWithoutLogin()
        }
        signup_button.setOnClickListener {
            navigator.signup()
        }
    }

    private fun login() {
        viewModel.getUser(
            username.text.toString(),
            password.text.toString()
        ).observe(this, Observer { user ->
            if (user != null) {
                navigator.login(user)
            } else {
                // display error
            }
        })
    }
}
