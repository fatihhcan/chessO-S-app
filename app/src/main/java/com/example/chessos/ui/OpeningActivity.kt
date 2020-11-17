package com.example.chessos.ui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.chessos.R
import com.example.chessos.core.Opening
import kotlinx.android.synthetic.main.activity_opening.*
import kotlinx.android.synthetic.main.list_card.view.*


class OpeningActivity : AppCompatActivity() {



    var constList=ArrayList<Opening>()
    var adapter:OpeningAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_opening)

        constList.add(Opening("Nuh'un Gemisi Tuzağı","Magnus Carlsen",R.drawable.opening128))
        constList.add(Opening("Légal Tuzağı","Fabiano Caruana",R.drawable.opening128))
        constList.add(Opening("Cambridge Springs Tuzağı","Ding Liren",R.drawable.opening128))
        constList.add(Opening("Lasker Tuzağı","Maxime Vachier-Lagrave",R.drawable.opening128))
        constList.add(Opening("Rubinstein Tuzağı","Ian Nepomniachtchi",R.drawable.opening128))
        constList.add(Opening("Sibirya Tuzağı","Levon Aronian",R.drawable.opening128))
        constList.add(Opening("Fajarowicz Tuzağı","Alexander Grischuk",R.drawable.opening128))
        constList.add(Opening("Blackburne Shilling Tuzağı","Wesley So",R.drawable.opening128))
        constList.add(Opening("Englund Gambiti Tuzağı","Shakhriyar Mamedyarov",R.drawable.opening128))
        constList.add(Opening("Olta Tuzağı","Teimour Radjabov",R.drawable.opening128))

        adapter= OpeningAdapter(this,constList)
        openingListView.adapter=adapter


    }
    class OpeningAdapter: BaseAdapter {
        var constList=ArrayList<Opening>()
        var context: Context?=null

        constructor(context: Context, constList:ArrayList<Opening>):super(){
            this.constList=constList
            this.context=context
        }
        override fun getCount(): Int {
            return constList.size
        }

        override fun getItem(position: Int): Any {
            return constList[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var positionOpening = constList[position]
            var inflator=context!!.getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var openingCard=inflator.inflate(R.layout.list_card,null)

            openingCard.cardTitle.text = positionOpening.constTitle
            openingCard.cardName.text = positionOpening.constName
            openingCard.imageCard.setImageResource(positionOpening.constImage!!)
            return openingCard

        }
    }
}