package com.mercari.roadtripgames.login.signup

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.mercari.roadtripgames.R
import com.mercari.roadtripgames.RoadTripApplication
import com.mercari.roadtripgames.utils.ToastProvider
import kotlinx.android.synthetic.main.activity_number_plate.toolbar
import kotlinx.android.synthetic.main.activity_signup.*
import javax.inject.Inject

class SignupActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: SignupViewModel

    @Inject
    lateinit var navigator: SignupContract.Navigator

    @Inject
    lateinit var toastProvider: ToastProvider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        (this.application as RoadTripApplication)
            .appComponent
            .newSignupComponent()
            .activity(this)
            .build()
            .inject(this)

        setupToolbar()
        setupOnClickListeners()
        setupValidationListeners()
        setupUserListener()
    }

    private fun setupToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun setupUserListener() {
        viewModel.user.observe(this, Observer { user ->
            navigator.signup(user)
        })
    }

    private fun setupOnClickListeners() {
        create_user_button.setOnClickListener {
            viewModel.createUser(
                username.text.toString(),
                password.text.toString(),
                confirm_password.text.toString()
            )
        }
    }

    private fun setupValidationListeners() {
        viewModel.usernameValidation.observe(this, Observer { errorMessage ->
            username.error = errorMessage
        })
        viewModel.passwordValidation.observe(this, Observer { errorMessage ->
            password.error = errorMessage
            confirm_password.error = errorMessage
        })
        viewModel.existingUserError.observe(this, Observer { exists ->
            if (exists) {
                toastProvider.showToast("This username already exists")
                username.error = "This username already exists"
            }
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return true
    }
}