package com.example.chessos.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.chessos.R
import com.example.chessos.core.DetailActivity
import com.example.chessos.core.Opening
import kotlinx.android.synthetic.main.activity_opening.*
import kotlinx.android.synthetic.main.list_card.view.*


class OpeningActivity : AppCompatActivity() {



    var constList=ArrayList<Opening>()
    var adapter:OpeningAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_opening)

        constList.add(Opening("Nuh'un Gemisi Tuzağı","Magnus Carlsen",R.drawable.plan,"1. e4 e5\n" +
                "2. f3 c6\n" +
                "3. b5 a6\n" +
                "4. a4 d6\n" +
                "5. d4 b5\n" +
                "6. b3 xd4\n" +
                "7. xd4\n" +
                "8. xd4 c5\n" +
                "9. d5 e6\n" +
                "10. c6+ d7\n" +
                "11. d5 c4"))
        constList.add(Opening("Légal Tuzağı","Fabiano Caruana",R.drawable.plan,"1.e4 e5\n" +
                "2.f3 c6\n" +
                "3.c4 d6\n" +
                "4.c3 g4\n" +
                "5.h3 h5\n" +
                "6. xe5 xd1\n" +
                "7. xf7+ e7\n" +
                "8.d5#"))
        constList.add(Opening("Cambridge Springs Tuzağı","Ding Liren",R.drawable.plan,"1.d4 d5\n" +
                "2.c4 e6\n" +
                "3.c3 f6\n" +
                "4.g5 bd7\n" +
                "5.cxd5 exd5\n" +
                "6.xd5...\n" +
                "7.xd8 b4+\n" +
                "8.d2 xd2+\n" +
                "9.xd2 xd8"))
        constList.add(Opening("Lasker Tuzağı","Maxime Vachier-Lagrave",R.drawable.plan,"1.d4 d5\n" +
                "2.c4 e5\n" +
                "3.dxe5 d4\n" +
                "4.e3 b4+\n" +
                "5.d2 dxe3\n" +
                "6.xb4 exf2+\n" +
                "7.e2 fxg1\n" +
                "8.e1 xg1\n" +
                "8... h4+\n" +
                "9.d2 c6\n" +
                "10.c3 g4\n" +
                "11. e2\n" +
                " O-O-O+"))
        constList.add(Opening("Rubinstein Tuzağı","Ian Nepomniachtchi",R.drawable.plan,"1.d4 d5\n" +
                "2.f3 f6\n" +
                "3.c4 e6\n" +
                "4.g5 bd7\n" +
                "5.e3 e7\n" +
                "6.c3 O-O\n" +
                "7.c1 e8\n" +
                "8.c2 a6\n" +
                "9.cxd5 exd5\n" +
                "10.d3 c6\n" +
                "11.O-O e4\n" +
                "12.f4 f5\n" +
                "13.xd5 cxd5\n" +
                "14. c7"))
        constList.add(Opening("Sibirya Tuzağı","Levon Aronian",R.drawable.plan,"1.e4 c5\n" +
                "2.d4 cxd4\n" +
                "3.c3 dxc3\n" +
                "4.xc3 c6\n" +
                "5.f3 e6\n" +
                "6.c4 c7\n" +
                "7.O-O f6\n" +
                "8.e2 g4\n" +
                "9.h3 d4\n" +
                "10. xd4 xf3+\n" +
                "11.xf3 h2#"))
        constList.add(Opening("Fajarowicz Tuzağı","Alexander Grischuk",R.drawable.plan,"1.d4 f6\n" +
                "2.c4 e5\n" +
                "3.dxe5 e4\n" +
                "4.f3 d6\n" +
                "5.exd6 xd6\n" +
                "6.g3 xf2\n" +
                "7.xf2 xg3+"))
        constList.add(Opening("Blackburne Shilling Tuzağı","Wesley So",R.drawable.plan,"1.e4 e5\n" +
                "2.f3 c6\n" +
                "3.c4 d4\n" +
                "4.xe5 g5\n" +
                "5.xf7 xg2\n" +
                "6.f1 xe4+\n" +
                "7.e2 f3#"))
        constList.add(Opening("Englund Gambiti Tuzağı","Shakhriyar Mamedyarov",R.drawable.plan,"1.d4 e5\n" +
                "2.dxe5 c6\n" +
                "3.f3 e7\n" +
                "4.f4 b4+\n" +
                "5.d2 xb2\n" +
                "6.c3 b4\n" +
                "7.d2 xc3\n" +
                "8.xc3 c1#"))
        constList.add(Opening("Olta Tuzağı","Teimour Radjabov",R.drawable.plan,"1.e4 e5\n" +
                "2.f3 c6\n" +
                "3.b5 f6\n" +
                "4.O-O g4\n" +
                "5.h3 h5\n" +
                "6.hxg4 hxg4\n" +
                "7.e1 h4\n" +
                "8.f3 g3\n" +
                "9.d4 h2#"))

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

            openingCard.layoutCard.setOnClickListener {
                var intent = Intent(context,DetailActivity::class.java)
                intent.putExtra("constTitle",positionOpening.constTitle)
                intent.putExtra("constName",positionOpening.constName)
                intent.putExtra("constImage",positionOpening.constImage)
                intent.putExtra("constOpening",positionOpening.constOpening)
                context!!.startActivity(intent)

            }
            return openingCard

        }
    }
}