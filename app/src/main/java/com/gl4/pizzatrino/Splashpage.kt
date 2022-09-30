package com.gl4.pizzatrino

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.TextView

class Splashpage : AppCompatActivity() {
    lateinit var txtorder : TextView
    lateinit var txttime : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashpage)
        val order = intent.getStringExtra("order");
        txtorder=findViewById(R.id.splashText);
        txttime=findViewById(R.id.timerView);
        txtorder.text= order;
        timer.start()

    }

    val timer = object: CountDownTimer(5000, 1000) {
        override fun onTick(millisUntilFinished: Long) {
            txttime.text = (millisUntilFinished / 1000).toString()
        }

        override fun onFinish() {
            val MainMenu = Intent(this@Splashpage,MainActivity::class.java);
            startActivity(MainMenu);
        }
    }

}
