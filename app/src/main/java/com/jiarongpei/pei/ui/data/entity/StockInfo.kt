package com.jiarongpei.pei.ui.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "stock_info")
data class StockInfo(
    @PrimaryKey val stockSymbol: String,
    val companyName: String,
    val stockQuote: Double
)
