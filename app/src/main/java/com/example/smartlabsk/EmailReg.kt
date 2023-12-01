package com.example.smartlabsk

import APIob
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import retrofit2.Callback
import retrofit2.Call
import retrofit2.Response
import androidx.appcompat.widget.AppCompatButton
import com.example.smartlabsk.databinding.ActivityEmailRegBinding

class EmailReg : AppCompatActivity(), TextWatcher {
    public var binding : ActivityEmailRegBinding? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEmailRegBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        binding!!.editTextTextEmailAddress.addTextChangedListener(this)
        binding!!.button.setOnClickListener {
            APIob.retrofitService.SendCodeOnEmail(binding!!.editTextTextEmailAddress.text.toString())
                .enqueue(object : Callback<String> {

                    override fun onFailure(call: Call<String>, t: Throwable) {

                        Toast.makeText(this@EmailReg, t.message, Toast.LENGTH_LONG).show()

                    }

                    override fun onResponse(call: Call<String>, response: Response<String>) {

                        APIob.User_mail = binding!!.editTextTextEmailAddress.text.toString()
                        val intent: Intent = Intent(this@EmailReg, EmailReg::class.java)
                        startActivity(intent)
                    }
                })
        }
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        checkEmail()
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        checkEmail()
    }

    override fun afterTextChanged(s: Editable?) {
        checkEmail()
    }

    private fun checkEmail() {
        if (binding != null) {
            if (Regex("^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$").containsMatchIn(
                    binding!!.editTextTextEmailAddress.text
                )
            ) {
                binding!!.button.isEnabled = true
                binding!!.button.setBackgroundResource(R.drawable.colorbtm)
            } else {
                binding!!.button.isEnabled = false
                binding!!.button.setBackgroundResource(R.drawable.uncolorbtm)
            }
        }

    }

}