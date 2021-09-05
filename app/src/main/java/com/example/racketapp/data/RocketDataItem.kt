package com.example.racketapp.data

import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Rockets_table")
data class RocketDataItem(

    @ColumnInfo(name = "Active_Status")
    val active: Boolean,

    /*val boosters: Int,
    val company: String,*/

    @ColumnInfo(name = "Cost_Per_Launch")
    val cost_per_launch: Int,

    @ColumnInfo(name = "Country")
    val country: String,

    @ColumnInfo(name="Description")
    val description: String,

    @ColumnInfo(name = "Diameter")
    val diameter: Diameter,

    @ColumnInfo(name = "Engines")
    val engines: Engines,
    /*val first_flight: String,
    val first_stage: FirstStage,*/

    @ColumnInfo(name = "Images")
    val flickr_images: ArrayList<String>,

    @ColumnInfo(name= "Height")
    val height: Height,

    /*val id: String,
    val landing_legs: LandingLegs,
    val mass: Mass,*/
    @PrimaryKey
    @ColumnInfo(name = "Name")
    var name: String,

    /*val payload_weights: List<PayloadWeight>,
    val second_stage: SecondStage,
    val stages: Int,*/

    @ColumnInfo(name= "Success_Rate_Pct")
    val success_rate_pct: Int,

    /*val type: String,*/

    @ColumnInfo(name= "Wiki_Link")
    val wikipedia: String
)