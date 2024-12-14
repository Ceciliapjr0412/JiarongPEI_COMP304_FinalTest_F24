package com.jiarongpei.pei.ui;


import android.app.Application
import androidx.room.Room
import com.jiarongpei.pei.ui.data.database.AppDatabase

class MyApp : Application() {
    lateinit var database: AppDatabase

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(
            this,
            AppDatabase::class.java,
            "app_database"
        ).build()
    }
}
