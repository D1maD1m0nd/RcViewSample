package com.example.rcviewsample

import android.app.Application
import com.example.rcviewsample.data.remote.quest.QuestApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class QuestApp : Application() {
    lateinit var questApi: QuestApi
    override fun onCreate() {
        super.onCreate()
        configureRetrofit()
    }

    private fun configureRetrofit() {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val okHttpclient = OkHttpClient
            .Builder()
            .addInterceptor(httpLoggingInterceptor).build()

        val retrofit = Retrofit
            .Builder()
            .baseUrl("https://nameless-brook-5907.getsandbox.com")
            .client(okHttpclient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        questApi = retrofit.create(QuestApi::class.java)
    }
}