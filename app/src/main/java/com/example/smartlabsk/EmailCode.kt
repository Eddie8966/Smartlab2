package com.example.smartlabsk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.text.Editable
import com.example.smartlabsk.databinding.ActivityEmailCodeBinding
import com.example.smartlabsk.databinding.ActivityEmailRegBinding
import java.util.Timer
import kotlin.time.Duration.Companion.hours
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds

class EmailCode : AppCompatActivity() {
    var binding : ActivityEmailCodeBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEmailCodeBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        timer.start()
    }
    val timer = object : CountDownTimer(60000,1000)
    {
        override fun onTick(millisUntilFinished: Long) {
            binding!!.count.text = "Отправить код повторно можно будет через " + millisUntilFinished.milliseconds.inWholeSeconds + " секунд"
        }

        override fun onFinish() {
            start()
        }
    }
}