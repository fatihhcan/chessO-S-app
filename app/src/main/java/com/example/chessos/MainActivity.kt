package com.example.chessos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.chessos.ui.OpeningActivity
import com.example.chessos.ui.StoriesActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        var intentOpening = Intent(this, OpeningActivity::class.java)
        var intentStories = Intent(this, StoriesActivity::class.java)


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    var buttonOpening = findViewById<Button>(R.id.buttonOpening)

    var buttonStories = findViewById<Button>(R.id.buttonStories)

        buttonOpening.setOnClickListener {
        startActivity(intentOpening)
        }

        buttonStories.setOnClickListener {
        startActivity(intentStories)
        }
    }


}