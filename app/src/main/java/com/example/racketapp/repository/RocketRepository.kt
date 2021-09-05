package com.example.racketapp.repository


import android.util.Log
import androidx.room.withTransaction
import com.example.racketapp.util.NetworkBoundResource
import com.example.racketapp.database.RocketDatabase
import com.example.racketapp.network.RetroService
import kotlinx.coroutines.*
import javax.inject.Inject

class RocketRepository @Inject
constructor(private val retroService: RetroService,private val rocketDatabase: RocketDatabase) {

    private val rocketDao = rocketDatabase.rocketDao()

    fun getRocketData() = NetworkBoundResource(
        query = {
            rocketDao.getRocketData()
        },
        fetch = {
            delay(2000)
            retroService.getRocketApi()
        },
        saveFetchResult = { rocketDataItems->
            rocketDatabase.withTransaction {
                rocketDao.deleteAllRecords()
                rocketDao.insert(rocketDataItems)
                Log.d("ritem",rocketDataItems.toString())
            }
        },shouldFetch = {true}
    )
}