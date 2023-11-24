package com.example.loginfrd

import android.provider.ContactsContract

//stores the user id, username, and password in string format
data class UserData(
    val id: String? =null,
    val email: String? = null,
    val password: String? = null,

)
