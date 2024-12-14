package com.jiarongpei.pei.ui.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jiarongpei.pei.ui.data.dao.StockInfoDao
import com.jiarongpei.pei.ui.data.entity.StockInfo

@Database(entities = [StockInfo::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun stockInfoDao(): StockInfoDao
}
