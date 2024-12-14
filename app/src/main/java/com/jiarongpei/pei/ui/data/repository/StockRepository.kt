package com.jiarongpei.pei.ui.data.repository

import com.jiarongpei.pei.ui.data.dao.StockInfoDao
import com.jiarongpei.pei.ui.data.entity.StockInfo

class StockRepository(private val stockInfoDao: StockInfoDao) {
    suspend fun insertStock(stockInfo: StockInfo) = stockInfoDao.insert(stockInfo)
    suspend fun getAllStocks() = stockInfoDao.getAllStocks()
    suspend fun getStockBySymbol(symbol: String) = stockInfoDao.getStockBySymbol(symbol)
}
