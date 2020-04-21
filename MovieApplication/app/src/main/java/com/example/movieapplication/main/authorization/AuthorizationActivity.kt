package com.example.movieapplication.main.authorization

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.movieapplication.R
import com.example.movieapplication.main.MainActivity
import com.example.movieapplication.utilities.AppPreferences
import kotlinx.android.synthetic.main.authorization.*
import org.koin.android.ext.android.inject

class AuthorizationActivity : AppCompatActivity(){
    private val loginViewModel: AuthorizationViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.authorization)


        editTextUsername.setText("admin")
        editTextPassword.setText("12345")
        buttonLogin.setOnClickListener{
            loginViewModel.login(
                username = editTextUsername.text.toString(),
                password = editTextPassword.text.toString()
            )
        }
        inputData()
    }
    private fun inputData() {
        loginViewModel.liveData.observe(this, Observer { state ->
            when(state) {
                is AuthorizationViewModel.State.ShowLoading -> {
                    progressBar.visibility = View.VISIBLE
                }
                is AuthorizationViewModel.State.HideLoading -> {
                    progressBar.visibility = View.INVISIBLE
                }
                is AuthorizationViewModel.State.ApiResult -> {
                    if (state.success && !state.session_id.isNullOrEmpty()) {
                        val intent = Intent(this, MainActivity::class.java)
                        AppPreferences.setAccountId(this, state.account_id)
                        AppPreferences.setSessionId(this, state.session_id)
                        startActivity(intent)
                        finish()
                    } else {
                        Toast.makeText(this, "Invalid username, password credentials", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
    }
}