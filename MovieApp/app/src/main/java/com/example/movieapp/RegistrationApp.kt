package com.example.movieapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.movieapp.api.Login
import com.example.movieapp.api.Post
import com.example.movieapp.api.Token
import com.example.movieapp.api.Users
import kotlinx.android.synthetic.main.registration.*
import kotlinx.android.synthetic.main.registration.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegistrationApp : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registration)

        pref = getSharedPreferences(APP_PREFERENCES, MODE_PRIVATE)
        getToken()
        login_button.setOnClickListener{
            login()
        }
    }


    fun login(){
        var token = pref.getString(TOKEN_KEY,"error")
        if(token!="error") {
            var login: Login = Login(login_view.text.toString(), password_view.text.toString(),token)
            var call: Call<Token> = RetrofitService.getPostApi().login(login)
            call.enqueue(object : Callback<Token> {
                override fun onFailure(call: Call<Token>, t: Throwable) {
                    Toast.makeText(this@RegistrationApp, "ERROR WITH CONNECTION", Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(call: Call<Token>, response: Response<Token>) {
                    if(response.isSuccessful){
                        var answer:Token? = response.body()
                        if(answer!!.success==true){
                            val intent = Intent(this@RegistrationApp, MainActivity::class.java)

                            startActivity(intent)
                        }
                        else{

                        }
                    }
                    else{
                        Toast.makeText(this@RegistrationApp, "Login or password is not correct", Toast.LENGTH_SHORT).show()

                    }
                }
            })
        }
        else{
            Log.d("Shared preferences","Could not correctly get token from shared preferences")
        }
    }


    fun getToken(){

        var call : Call<Token> =  RetrofitService.getPostApi().getToken()
        call.enqueue(object : Callback<Token>{
            override fun onFailure(call: Call<Token>, t: Throwable) {
                Toast.makeText(this@RegistrationApp, "ERROR", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<Token>, response: Response<Token>) {
                if(response.isSuccessful){
                    var answer:Token? = response.body()
                    val editor = pref.edit()
                    editor.putString(TOKEN_KEY, answer!!.request_token)
                    editor.apply()
                }
                else{
                    Toast.makeText(this@RegistrationApp, "Api key is not correct ", Toast.LENGTH_SHORT).show()

                }
            }
        })
    }
}
