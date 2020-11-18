package com.example.chessos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.chessos.ui.OpeningActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        var intent = Intent(this, OpeningActivity::class.java)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    var buttonOpening = findViewById<Button>(R.id.buttonOpening)
        buttonOpening.setOnClickListener {
        startActivity(intent)

        }
    }


}