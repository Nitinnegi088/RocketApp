package com.example.racketapp.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.racketapp.R
import com.example.racketapp.adapters.RocketAdapter
import com.example.racketapp.data.RocketDataItem
import com.example.racketapp.viewModel.RocketViewModel
import com.example.racketapp.util.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(),RocketAdapter.OnItemClickListener{

    private lateinit var tv_loading: ProgressBar
    private lateinit var recyclerView: RecyclerView
    private lateinit var rocketAdapters: RocketAdapter
    private lateinit var tv_error: TextView

    private val viewModel: RocketViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv_error = findViewById(R.id.text_view_error)
        rocketAdapters = RocketAdapter(this,ArrayList<RocketDataItem>(),this)
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager= LinearLayoutManager(this@MainActivity)
            adapter =rocketAdapters
        }
        viewModel.rockets.observe(this@MainActivity){ rockets->

            rocketAdapters.setData(rockets.data as ArrayList<RocketDataItem>)
            tv_loading.isVisible = rockets is Resource.Loading && rockets.data.isNullOrEmpty()
            tv_error.isVisible = rockets is Resource.Error && rockets.data.isNullOrEmpty()
        }
    }

    override fun onItemClick(rockDataItem: RocketDataItem) {
        intent = Intent(this,RocketDetail::class.java)
        intent.putExtra(RocketDetail.NAME, rockDataItem.name)
        intent.putExtra(RocketDetail.ROCKET_IMAGES, rockDataItem.flickr_images)
        intent.putExtra(RocketDetail.ACTIVE_STATUS, rockDataItem.active)
        intent.putExtra(RocketDetail.CPL, rockDataItem.cost_per_launch)
        intent.putExtra(RocketDetail.SRP, rockDataItem.success_rate_pct)
        intent.putExtra(RocketDetail.DESCRIPTION, rockDataItem.description)
        intent.putExtra(RocketDetail.WIKIPEDIA_LINK, rockDataItem.wikipedia)
        intent.putExtra(RocketDetail.HEIGHT, rockDataItem.height?.meters)
        intent.putExtra(RocketDetail.DIAMETER, rockDataItem.diameter?.meters)
        startActivity(intent)
    }
}