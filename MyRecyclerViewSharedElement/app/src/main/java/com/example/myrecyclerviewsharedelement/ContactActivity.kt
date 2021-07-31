package com.example.myrecyclerviewsharedelement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class ContactActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deteil_contact)


        val personsImage: ImageView = findViewById(R.id.image_person)
        val contname:TextView = findViewById(R.id.name)
        val phoneNumber :TextView = findViewById(R.id.phoneNumber)
        var email:TextView = findViewById(R.id.email)

        var bundle : Bundle? = intent.extras
        var person = bundle?.getInt("image")
        var contactName = bundle?.getString("name")
        var number = bundle?.getString("phoneNumber")
        var emaill = bundle?.getString("email")

        phoneNumber.text = number
        email.text = emaill
        contname.text = contactName
        if (person != null) {
            personsImage.setImageResource(person)
        }

    }
}