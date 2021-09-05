package com.example.racketapp.database


import androidx.room.*
import com.example.racketapp.converter.Converter
import com.example.racketapp.dao.RocketDao
import com.example.racketapp.data.RocketDataItem

@Database(entities = [RocketDataItem::class],version = 1, exportSchema = false)
@TypeConverters(Converter::class)
abstract class RocketDatabase: RoomDatabase() {

    abstract fun rocketDao(): RocketDao

}