package com.example.assesment3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.assesment3.databinding.ActivityMain2Binding
import com.example.assesment3.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onResume() {
        super.onResume()
        binding.btnLogin.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            validateSignUp()
            clearErrors()


        }

    }

    fun validateSignUp() {
        val username = binding.etUsernameLog.text.toString()
        val password = binding.etPasswordIn.text.toString()



        var error = false
        if (username.isBlank()) {
            binding.tilUsernameLog.error = "First name is required"
            error = true
        }
        if (password.isBlank()) {
            binding.tilPasswordIn.error = "Email is required"
            error = true
        }


        if (!error) {
            binding.btnLogin.setOnClickListener {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }

        }
    }

    private fun clearErrors() {
        binding.tilUsernameLog.error = null

        binding.tilPasswordIn.error = null

    }

}