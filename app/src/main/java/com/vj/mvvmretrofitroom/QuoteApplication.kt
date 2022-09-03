package com.vj.mvvmretrofitroom

import android.app.Application
import com.vj.mvvmretrofitroom.api.QuoteService
import com.vj.mvvmretrofitroom.api.RetrofitHelper
import com.vj.mvvmretrofitroom.db.QuoteDB
import com.vj.mvvmretrofitroom.repository.QuoteRepository


class QuoteApplication:Application() {
    lateinit var quoteRepository: QuoteRepository

    lateinit var quoteService: QuoteService
    lateinit var quoteDB: QuoteDB
    override fun onCreate() {
        super.onCreate()
        initilize()
    }

    private fun initilize() {
        quoteService= RetrofitHelper.getInstace().create(QuoteService::class.java)
        quoteDB=QuoteDB.getInstance(applicationContext)
        quoteRepository= QuoteRepository(quoteService,quoteDB,applicationContext)

    }
}

