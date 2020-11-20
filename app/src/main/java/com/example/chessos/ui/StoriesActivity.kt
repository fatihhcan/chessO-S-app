package com.example.chessos.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.chessos.R
import com.example.chessos.core.DetailActivity
import com.example.chessos.core.Opening
import com.example.chessos.core.Stories
import com.example.chessos.core.StoriesDetailActivity
import kotlinx.android.synthetic.main.activity_opening.*
import kotlinx.android.synthetic.main.activity_stories.*
import kotlinx.android.synthetic.main.list_card.view.*
import kotlinx.android.synthetic.main.stories_card.view.*

class StoriesActivity : AppCompatActivity() {

    var constList=ArrayList<Stories>()
    var adapter: StoriesAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stories)

        constList.add(Stories("Nuh'un Gemisi Tuzağı","Nuh'un Gemisi tuzağındaki ana fikir, beyazların açık renkli filini birkaç zoraki hamle sonucunda tuzağa düşürmektir. Bu tuzak, Ruy Lopez açılışında siyahlarla oynayan oyuncular içindir.\n" +
                "\n",R.drawable.stories))
        constList.add(Stories("Légal Tuzağı","18. yüzyıldan günümüze ulaşan bu tuzağın ismi Sire de Légal'den gelmektedir. Pek çok satranç oyuncusunun favorisi olan bu tuzakta harika bir vezir fedası bulunmaktadır." +
                "\n",R.drawable.stories))
        constList.add(Stories("Cambridge Springs Tuzağı","Cambridge Springs tuzağı, Reddedilen Vezir Gambiti'nde yaygın olarak oynanan birkaç hamleden sonra ortaya çıkmaktadır." +
                "\n",R.drawable.stories))
        constList.add(Stories("Lasker Tuzağı","Lasker tuzağının ismi, ikinci Satranç Dünya Şampiyonu Emanuel Lasker'den gelmektedir. Bu tuzağın en güzel kısmı, düşük terfiyle ata terfi etmeyi kullanmasıdır. Beyazların vezir gambitine karşılık, siyahlar Albin karşı-gambitini oynamaktadır." +
                "\n",R.drawable.stories))
        constList.add(Stories("Rubinstein Tuzağı","Rubinstein Tuzağı'nın ismi bir başka satranç devi Akiba Rubinstein'dan gelmektedir. Bu incelikli tuzakta en azından bir er kazanacak olsanız da, siyahlar eğer haddinden fazla açgözlü davranırsa, siyah veziri bile kapana kıstırmanız mümkün." +
                "\n",R.drawable.stories))
        constList.add(Stories("Sibirya Tuzağı","Smith-Morra Gambiti'ndeki bu tuzak, her seviyedeki pek çok oyuncuyu avlamıştır! Beyazlar doğal gelişim hamleleri yapıyormuş gibi görünse de bir anda vezirini kaybetmekte ve şah mat olmaktadır!" +
                "\n",R.drawable.stories))
        constList.add(Stories("Fajarowicz Tuzağı","Bu sinsi tuzak Budapeşte Gambiti açılışında ortaya çıkmaktadır. Siyahlar iki hafif taş fedası sonrası beyaz veziri elde etmektedir." +
                "\n",R.drawable.stories))
        constList.add(Stories("Blackburne Shilling Tuzağı","Bu tuzakta, beyazları hazırlıksız yakalayabilmek için siyahlar, açılışlara dair tüm temel prensipleri hiçe saymaktadır. Öncelikle siyahlar dikkatsizce hamleler yapıyormuş gibi görünse de, 5...Vxg2 hamlesinden sonra aslında kimin başının belada olduğunu görebiliyorsunuz. Bu tuzak, Giuoco Piano olarak da bilinen İtalyan Açılışı'nın bir devam yolunda ortaya çıkmaktadır." +
                "\n",R.drawable.stories))
        constList.add(Stories("Englund Gambiti Tuzağı","Siyahlar cesurca (veya dikkatsizce!) 1.d4 hamlesine 1...e5?! ile yanıt veriyor. Siyahlarla oynarken açılış hamlenizde yapabileceğiniz en kışkırtıcı hamle muhtemelen bu hamle olacaktır! Bu tuzakta birkaç tane ilginç taktik fikir var ve pek fazla taş değişimi olmasa da tuzak, sonuçta siyahların beyazları mat etmesiyle sonuçlanmaktadır.\n" +
                "\n",R.drawable.stories))
        constList.add(Stories("Olta Tuzağı","Tuzaklara dair bu dizimizi Ruy Lopez'e karşı oynanan eğlenceli bir hamleyle tamamlıyoruz. Burada g4'teki at yem, h5'teki er ise birilerini hazırlıksız yakalamak için bekleyen oltadır! Çevrimiçi oyunlarınızda ve karşılıklı yıldırım oyunlarınızda denemesi oldukça eğlenceli bir tuzaktır." +
                "\n",R.drawable.stories))


        adapter= StoriesAdapter(this, constList)
        storiesListView.adapter=adapter
    }

    class StoriesAdapter: BaseAdapter {
        var constList=ArrayList<Stories>()
        var context: Context?=null

        constructor(context: Context, constList:ArrayList<Stories>):super(){
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
            var openingCard=inflator.inflate(R.layout.stories_card,null)

            openingCard.cardStoriesTitle.text = positionOpening.constStoriesTitle
            openingCard.cardDesName.text = positionOpening.constStoriesDes
            openingCard.imageStoriesCard.setImageResource(positionOpening.constStoriesImage!!)

            openingCard.layoutStoriesCard.setOnClickListener {
                var intent = Intent(context,StoriesDetailActivity::class.java)
                intent.putExtra("constStoriesTitle",positionOpening.constStoriesTitle)
                intent.putExtra("constStoriesDes",positionOpening.constStoriesDes)
                intent.putExtra("constStoriesImage",positionOpening.constStoriesImage)
                context!!.startActivity(intent)

            }

            return openingCard

        }
    }
}