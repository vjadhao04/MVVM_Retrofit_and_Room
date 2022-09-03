package com.vj.mvvmretrofitroom.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.vj.mvvmretrofitroom.api.QuoteService
import com.vj.mvvmretrofitroom.db.QuoteDB
import com.vj.mvvmretrofitroom.models.QuoteList
import com.vj.mvvmretrofitroom.models.Result
import com.vj.mvvmretrofitroom.utils.NetworkUtil

class QuoteRepository(
    val quoteService: QuoteService,
    val quoteDB: QuoteDB,
    val context: Context
) {

    private val quoteslivedata = MutableLiveData<QuoteList>()

    val quotes: LiveData<QuoteList>
        get() = quoteslivedata


    suspend fun getQuotes(page: Int) {

        if(NetworkUtil.isInternetAvailable(context)){
            val result = quoteService.getQuote(page)
            if (result.body() != null) {
                quoteDB.getDao().insertQuote(result.body()!!.results)
                quoteslivedata.postValue(result.body())
            }
        }
        else{
            val result=quoteDB.getDao().getQuotes()
            val quoteList=QuoteList(1,1,1,result,1,1)
            quoteslivedata.postValue(quoteList)
        }

    }
}