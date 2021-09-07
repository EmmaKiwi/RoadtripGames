package com.mercari.roadtripgames.login

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.mercari.roadtripgames.R
import com.mercari.roadtripgames.RoadTripApplication
import com.mercari.roadtripgames.utils.ToastProvider
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_number_plate.*
import javax.inject.Inject

class LoginActivity: AppCompatActivity() {

    @Inject
    lateinit var navigator: LoginContract.Navigator

    @Inject
    lateinit var viewModel: LoginViewModel

    @Inject
    lateinit var toastProvider: ToastProvider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        setupDi()
        setupOnClickListeners()
        setupValidation()
        setupUserListener()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == LoginNavigator.SIGNUP_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                viewModel.onSignupReturn()
            }
        }
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
        viewModel.userNotFoundError.observe(this, Observer { notFound ->
            if (notFound) {
                toastProvider.showToast("Username and password combination is invalid.")
            }
        })
    }

    private fun setupUserListener() {
        viewModel.user.observe(this, Observer {
            navigator.login()
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
        stay_logged_in.setOnCheckedChangeListener { buttonView, isChecked ->
            viewModel.onStayLoggedInChecked(isChecked)
        }
    }

    private fun login() {
        viewModel.login(
            username.text.toString(),
            password.text.toString()
        )
    }
}
