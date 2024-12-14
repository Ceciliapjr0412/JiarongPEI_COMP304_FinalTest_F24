package com.jiarongpei.pei.ui.viewmodel

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jiarongpei.pei.ui.data.entity.StockInfo
import com.jiarongpei.pei.ui.data.repository.StockRepository
import kotlinx.coroutines.launch

class StockViewModel(private val repository: StockRepository) : ViewModel() {

    val stocks = mutableListOf<StockInfo>()

    fun insertStock(stockInfo: StockInfo) {
        viewModelScope.launch {
            repository.insertStock(stockInfo)
            loadStocks()
        }
    }

    fun loadStocks() {
        viewModelScope.launch {
            stocks.clear()
            stocks.addAll(repository.getAllStocks())
        }
    }

    fun getStock(symbol: String, callback: (StockInfo) -> Unit) {
        viewModelScope.launch {
            callback(repository.getStockBySymbol(symbol))
        }
    }
}
