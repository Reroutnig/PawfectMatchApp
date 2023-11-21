package com.example.loginfrd

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.loginfrd.databinding.ActivityLoginBinding
import com.example.loginfrd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.logOutButton.setOnClickListener{
            startActivity(Intent(this@MainActivity, LoginActivity::class.java))
            Toast.makeText(this@MainActivity, "Logout Successful", Toast.LENGTH_SHORT).show()
            finish()

        }
    }

}
