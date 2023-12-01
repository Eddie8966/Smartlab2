package com.example.smartlabsk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class BasketScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basket_screen)
    }
        fun onMyButtonClick(view: View?) {

            val intent = Intent (this@BasketScreen,    PatientCardScreen::class.java)
            startActivity(intent)
        }
    }