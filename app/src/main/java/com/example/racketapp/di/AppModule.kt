package com.example.racketapp.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.racketapp.database.RocketDatabase
import com.example.racketapp.network.RetroService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.internal.http.RetryAndFollowUpInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideDatabase(app: Application) : RocketDatabase =
        Room.databaseBuilder(app, RocketDatabase::class.java, "rocket_database").fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun getRetroInstance(retrofit: Retrofit):RetroService{
        return retrofit.create(RetroService::class.java)
    }

    @Provides
    @Singleton
    fun getRetrofitInstance(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(RetroService.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}