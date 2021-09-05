package com.example.racketapp.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.racketapp.data.RocketData
import com.example.racketapp.data.RocketDataItem
import kotlinx.coroutines.flow.Flow
import retrofit2.Call

@Dao
interface RocketDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(rocketDataItem: List<RocketDataItem>)

    @Query("SELECT * FROM ROCKETS_TABLE")
    fun getRocketData(): Flow<List<RocketDataItem>>

    @Query("DELETE FROM ROCKETS_TABLE")
    suspend fun deleteAllRecords()

}