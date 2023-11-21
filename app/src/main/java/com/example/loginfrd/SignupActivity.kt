package com.example.loginfrd

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.loginfrd.databinding.ActivitySignupBinding
import com.google.firebase.auth.FirebaseAuth
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
    private lateinit var firebaseAuth: FirebaseAuth



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()
        firebaseDatabase = FirebaseDatabase.getInstance()
        databaseReference =  firebaseDatabase.reference.child("users")

        binding.signupButton.setOnClickListener{
          val email = binding.signupEmail.text.toString()
          val password = binding.signupPassword.text.toString()

          if(email.isNotEmpty() && password.isNotEmpty()){
              //for database
              signupUser(email, password)
              //for authentication
              firebaseAuth.createUserWithEmailAndPassword(email,password)
                  .addOnCompleteListener(this) {task ->
                      //if user created successful go to login page
                      if(task.isSuccessful){
                          Toast.makeText(this@SignupActivity, "Signup Successful!", Toast.LENGTH_SHORT).show()
                          val intent = Intent(this, LoginActivity::class.java)
                        startActivity(intent)
                          finish()
                      }else{
                          Toast.makeText(this@SignupActivity, "Signup Unsuccessful", Toast.LENGTH_SHORT).show()
                      }
                  }
          }else{
              Toast.makeText(this@SignupActivity, "Enter Email and Password", Toast.LENGTH_SHORT).show()
          }
        }
        //if user already have account then redirects to login page
    binding.loginRedirect.setOnClickListener{
        startActivity(Intent(this,LoginActivity::class.java))
        finish()
    }
}

    //updates database with new user
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
                   //toast.makeText(this@SignupActivity, "Signup Successful!", Toast.LENGTH_SHORT).show()
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