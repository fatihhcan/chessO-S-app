package com.example.chessos.core

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chessos.R
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        var bundle: Bundle? = intent.extras
        var title=bundle!!.getString("constTitle")
        var name= bundle.getString("constName")
        var image = bundle.getInt("constImage")
        var opening = bundle.getString("constOpening")

        textViewTitleDetail.text=title
        textViewNameDetail.text=name
        imageViewDetail.setImageResource(image)
        textViewOpening.text=opening

    }
}