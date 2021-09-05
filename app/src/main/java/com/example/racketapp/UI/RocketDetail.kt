package com.example.racketapp.UI

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.racketapp.R


class RocketDetail:AppCompatActivity() {

    companion object{
        const val NAME = "name"
        const val ROCKET_IMAGES = "rocketImages"
        const val ACTIVE_STATUS = "activeStatus"
        const val CPL = "ostPerLaunch"
        const val SRP = "successPerLaunch"
        const val DESCRIPTION = "description"
        const val WIKIPEDIA_LINK = "wikiLink"
        const val HEIGHT = "height"
        const val DIAMETER = "diameter"
    }

    private lateinit var name: TextView
    private lateinit var images: LinearLayout
    private lateinit var description: TextView
    private lateinit var wikiLink: TextView
    private lateinit var activeStatus: TextView
    private lateinit var cpl: TextView
    private lateinit var srp: TextView
    private lateinit var height: TextView
    private lateinit var diameter: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rocket_detail)
        initViews()
        setDetailData()
    }

    private fun setDetailData() {
        val name1 = intent.getStringExtra(NAME)
        val images1 =intent.getStringArrayListExtra(ROCKET_IMAGES)
        val description1 = intent.getStringExtra(DESCRIPTION)
        val wikilink1 = intent.getStringExtra(WIKIPEDIA_LINK)
        val activeStatus1 = intent.getBooleanExtra(ACTIVE_STATUS, false)
        val cpl1 = intent.getIntExtra(CPL, 0)
        val srp1 = intent.getIntExtra(SRP, 0)
        val height1 = intent.getFloatExtra(HEIGHT, 0.0f)
        val diameter1 = intent.getFloatExtra(DIAMETER, 0.0f)

        name.text = name1.toString()
        description.text = description1.toString()
        wikiLink.text = wikilink1.toString()
        activeStatus.text = activeStatus1.toString()
        cpl.text = cpl1.toString()
        srp.text = srp1.toString()
        height.text = height1.toString()
        diameter.text = diameter1.toString()

        val inflate  = LayoutInflater.from(this)

        for(i in images1?.indices!!) {
            val view = inflate.inflate(R.layout.image_view, images,false)
            val imagesView : ImageView = view.findViewById(R.id.imageView)
            Glide.with(this).load(images1[i]).into(imagesView)
            images.addView(view)
        }
    }

    private fun initViews() {
        name = findViewById(R.id.name)
        images = findViewById(R.id.images)
        description = findViewById(R.id.description)
        wikiLink = findViewById(R.id.wiki_link)
        activeStatus = findViewById(R.id.active_status)
        cpl = findViewById(R.id.cpl)
        srp = findViewById(R.id.srp)
        height = findViewById(R.id.height)
        diameter = findViewById(R.id.diameter)
    }
}