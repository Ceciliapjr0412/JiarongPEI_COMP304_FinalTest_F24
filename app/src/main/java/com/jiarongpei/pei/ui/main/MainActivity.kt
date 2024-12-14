package com.jiarongpei.pei.ui.main

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent


import com.jiarongpei.pei.ui.data.entity.StockInfo
import com.jiarongpei.pei.ui.data.repository.StockRepository
import com.jiarongpei.pei.ui.detail.DisplayActivity
import com.jiarongpei.pei.ui.viewmodel.StockViewModel
import com.jiarongpei.pei.R
import com.jiarongpei.pei.ui.MyApp

class MainActivity : ComponentActivity() {
    private lateinit var viewModel: StockViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val app = application as MyApp
        viewModel = StockViewModel(StockRepository(app.database.stockInfoDao()))

        setContent {
            // UI Code (Jetpack Compose or XML Layout)
            // Insert Stocks
            val stockSymbolInput = findViewById<EditText>(R.id.stockSymbol)
            val companyNameInput = findViewById<EditText>(R.id.companyName)
            val stockQuoteInput = findViewById<EditText>(R.id.stockQuote)
            val insertButton = findViewById<Button>(R.id.insertButton)

            insertButton.setOnClickListener {
                val stock = StockInfo(
                    stockSymbolInput.text.toString(),
                    companyNameInput.text.toString(),
                    stockQuoteInput.text.toString().toDouble()
                )
                viewModel.insertStock(stock)
            }

            // Display Stock Info
            val displayButton = findViewById<Button>(R.id.displayButton)
            displayButton.setOnClickListener {
                startActivity(Intent(this, DisplayActivity::class.java))
            }
        }
    }
}
