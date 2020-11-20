package com.example.chessos.core

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chessos.R
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_detail.imageViewDetail
import kotlinx.android.synthetic.main.activity_stories_detail.*

class StoriesDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stories_detail)


        var bundle: Bundle? = intent.extras
        var title=bundle!!.getString("constStoriesTitle")
        var name= bundle.getString("constStoriesDes")
        var image = bundle.getInt("constStoriesImage")


        textViewTitleDetailStories.text=title
        textViewOpeningStories.text=name
        imageViewDetailStories.setImageResource(image)


    }
}