package com.example.racketapp.converter

import androidx.room.TypeConverter
import com.example.racketapp.data.Diameter
import com.example.racketapp.data.Engines
import com.example.racketapp.data.Height
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


class Converter{

        @TypeConverter
        fun fromEngine(engines: Engines): Int {
            return engines.number
        }

        @TypeConverter
        fun toEngine(number: Int): Engines {
            return Engines(number)
        }

        @TypeConverter
        fun fromHeight(height: Height): Float {
            return height.meters
        }

        @TypeConverter
        fun toHeight(meters: Float): Height {
            return Height(meters)
        }

        @TypeConverter
        fun fromDiameter(diameter: Diameter): Float {
            return diameter.meters
        }

        @TypeConverter
        fun toDiameter(meters: Float): Diameter {
            return Diameter(meters)
        }

        @TypeConverter
        fun fromString(value: String?): ArrayList<String?>? {
            val listType: Type = object : TypeToken<ArrayList<String?>?>() {}.type
            return Gson().fromJson(value, listType)
        }

        @TypeConverter
        fun fromArrayList(list: ArrayList<String?>?): String? {
            val gson = Gson()
            return gson.toJson(list)
        }
}