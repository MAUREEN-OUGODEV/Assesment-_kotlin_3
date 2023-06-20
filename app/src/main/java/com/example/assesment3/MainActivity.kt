package com.example.assesment3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.assesment3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onResume() {
        super.onResume()
        binding.btnSignUp.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
            validateSignUp()
            clearErrors()


        }

    }

    fun validateSignUp() {
        val username = binding.etUsername.text.toString()
        val email = binding.etEmail.text.toString()
        val phoneNumber = binding.etPhoneNumber.text.toString()
        val password = binding.etPasswordUp.text.toString()
        val confirm = binding.etConfim.text.toString()


        var error = false
        if (username.isBlank()) {
            binding.tilUsername.error = "First name is required"
            error = true
        }
        if (email.isBlank()) {
            binding.tilEmail.error = "Email is required"
            error = true
        }
        if (phoneNumber.isBlank()) {
            binding.tilphoneNumber.error = "phone Number is required"
            error = true
        }
        if (password.isBlank()) {
            binding.tilPasswordUP.error = "Password is required"
            error = true
        }
        if (confirm.isBlank()) {
            binding.tilConfirm.error = "Confirm password is required"
            error = true
        }
        if (password != confirm) {
            binding.tilConfirm.error = "Passwords do not match"
            error = true
        }
        if (!error) {
            binding.tvLogin.setOnClickListener {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }

        }
    }

    private fun clearErrors() {
        binding.tilUsername.error = null
        binding.tilEmail.error = null
        binding.tilPasswordUP.error = null
        binding.tilConfirm.error = null
    }

}