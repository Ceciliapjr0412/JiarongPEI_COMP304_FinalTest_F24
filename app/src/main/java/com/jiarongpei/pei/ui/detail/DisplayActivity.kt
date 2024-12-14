package com.jiarongpei.pei.ui.detail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.jiarongpei.pei.ui.data.entity.StockInfo
import com.jiarongpei.pei.ui.viewmodel.StockViewModel

class DisplayActivity : ComponentActivity() {
    private lateinit var viewModel: StockViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Get selected stock data
        val stockSymbol = intent.getStringExtra("stockSymbol") ?: return

        setContent {
            viewModel.getStock(stockSymbol) { stock ->
                DisplayStock(stock)
            }
        }
    }
}

@Composable
fun DisplayStock(stock: StockInfo) {
    Text("Stock Symbol: ${stock.stockSymbol}")
    Text("Company Name: ${stock.companyName}")
    Text("Stock Quote: ${stock.stockQuote}")
}

@Preview
@Composable
fun DisplayStockPreview() {
    DisplayStock(StockInfo("AAPL", "Apple Inc.", 150.00))
}
