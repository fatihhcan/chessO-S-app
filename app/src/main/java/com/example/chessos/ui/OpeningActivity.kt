package com.example.chessos.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.example.chessos.R

class OpeningActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_opening)

        var listViewOpening = findViewById<ListView>(R.id.openingListView)
        var opening = arrayOf("Nuh'un Gemisi Tuzağı", "Légal Tuzağı", "Cambridge Springs Tuzağı","Lasker Tuzağı","Rubinstein Tuzağı","Sibirya Tuzağı", "Fajarowicz Tuzağı", "Blackburne Shilling Tuzağı", "Englund Gambiti Tuzağı","Olta Tuzağı" )

        var arrayAdapter : ArrayAdapter<String> = ArrayAdapter(
            this, android.R.layout.simple_list_item_1, opening
        )
        listViewOpening.adapter = arrayAdapter
        
        listViewOpening.setOnItemClickListener { adapterView, view, i, l ->

            Toast.makeText(this,"Item Selected" + opening[i],Toast.LENGTH_LONG).show()

        }
    }
}