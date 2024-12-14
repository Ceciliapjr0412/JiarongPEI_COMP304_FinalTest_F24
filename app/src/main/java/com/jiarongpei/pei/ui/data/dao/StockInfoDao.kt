package com.jiarongpei.pei.ui.data.dao

import androidx.room.*
import com.jiarongpei.pei.ui.data.entity.StockInfo

@Dao
interface StockInfoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(stockInfo: StockInfo)

    @Query("SELECT * FROM stock_info")
    suspend fun getAllStocks(): List<StockInfo>

    @Query("SELECT * FROM stock_info WHERE stockSymbol = :symbol")
    suspend fun getStockBySymbol(symbol: String): StockInfo

    @Delete
    suspend fun delete(stockInfo: StockInfo)
}
