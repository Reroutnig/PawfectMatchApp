package com.example.loginfrd

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.loginfrd.databinding.ActivitySignupBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class SignupActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding
    //connects to firebase

    private lateinit var firebaseDatabase: FirebaseDatabase
    private lateinit var databaseReference: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseDatabase = FirebaseDatabase.getInstance()
        databaseReference =  firebaseDatabase.reference.child("users")

        binding.signupButton.setOnClickListener{
          val signupEmail = binding.signupEmail.text.toString()
          val signupPassword = binding.signupPassword.text.toString()

          if(signupEmail.isNotEmpty() && signupPassword.isNotEmpty()){
              signupUser(signupEmail, signupPassword)
          }else{
              Toast.makeText(this@SignupActivity, "Please fill out all fields", Toast.LENGTH_SHORT).show()
          }
        }
        binding.loginRedirect.setOnClickListener{
            startActivity(Intent(this@SignupActivity, LoginActivity::class.java))
            finish()
        }


    }

    private fun signupUser(email: String, password: String){
        //sorts data
        databaseReference.orderByChild("email").equalTo(email).addListenerForSingleValueEvent(object:
            ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot){
                // if the user does not already exits, create a new user id
                if(!dataSnapshot.exists()){
                    val id = databaseReference.push().key
                    val userData = UserData(id, email, password)
                    //creates a unique user id
                    databaseReference.child(id!!).setValue(userData)
                    Toast.makeText(this@SignupActivity, "Signup Successful!", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this@SignupActivity, LoginActivity::class.java))
                    finish()
                }else{
                    Toast.makeText(this@SignupActivity, "User Already Exists", Toast.LENGTH_SHORT).show()
                }
            }
            override fun onCancelled(databaseError: DatabaseError){
                Toast.makeText(this@SignupActivity, "Database Error: ${databaseError.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}