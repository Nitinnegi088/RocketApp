package com.example.racketapp

import android.util.Log
import com.example.racketapp.util.Resource

import kotlinx.coroutines.flow.*

inline fun <ResultType,RequestType> NetworkBoundResource(
    crossinline query:() -> Flow<ResultType>,
    crossinline fetch: suspend ()-> RequestType,
    crossinline saveFetchResult: suspend (RequestType) -> Unit,
    crossinline shouldFetch:(ResultType) ->Boolean = {true}
) = flow {
    val data = query().first()
    val flow = if (shouldFetch(data)){
        emit(Resource.Loading(data))
        try {
            saveFetchResult(fetch())
            query().map { Resource.Success(it)
                Log.d("ritem1",it.toString())
            }

        }catch (throwable:Throwable){
            query().map { Resource.Error(throwable,it)
                Log.d("ritem2",it.toString())}
        }
    }else{
        query().map { Resource.Success(it)
            Log.d("ritem3",it.toString()) }
    }
    emitAll(flow)
}