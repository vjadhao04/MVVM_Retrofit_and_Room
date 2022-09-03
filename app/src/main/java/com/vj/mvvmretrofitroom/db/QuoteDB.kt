package com.vj.mvvmretrofitroom.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.vj.mvvmretrofitroom.models.Result

@Database(entities = [Result::class], version = 1)
abstract class QuoteDB:RoomDatabase() {
    abstract fun getDao(): QuotesDao

    companion object{
        @Volatile
        private var INSTANCE:QuoteDB?=null
        fun getInstance(context: Context):QuoteDB{
            if(INSTANCE==null){
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        QuoteDB::class.java, "quotesdb"
                    )
                        .build()
                }
                return INSTANCE!!
            }
            return INSTANCE!!
        }
    }
}