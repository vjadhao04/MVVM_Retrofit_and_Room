package com.vj.mvvmretrofitroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.viewModelFactory
import com.vj.mvvmretrofitroom.api.QuoteService
import com.vj.mvvmretrofitroom.api.RetrofitHelper
import com.vj.mvvmretrofitroom.db.QuoteDB
import com.vj.mvvmretrofitroom.models.QuoteList
import com.vj.mvvmretrofitroom.repository.QuoteRepository
import com.vj.mvvmretrofitroom.viewmodel.MainViewModel
import com.vj.mvvmretrofitroom.viewmodel.ViewModelFactory
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var quoteRepository: QuoteRepository



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        quoteRepository=(application as QuoteApplication).quoteRepository
        mainViewModel=ViewModelProvider(this, ViewModelFactory(quoteRepository)).get(MainViewModel::class.java)

        var quotes=mainViewModel.quotes
        quotes.observe(this, Observer {
            Log.d("mvvm",it.results.size.toString() )
        })

    }
}