package com.vj.mvvmretrofitroom.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

import com.vj.mvvmretrofitroom.models.Result

@Dao
interface QuotesDao {
   @Insert
   suspend fun insertQuote(quoteList: List<Result>)

   @Query("select * from quotes")
   suspend fun getQuotes():List<Result>
}