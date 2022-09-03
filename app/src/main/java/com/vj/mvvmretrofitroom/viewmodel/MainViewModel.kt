package com.vj.mvvmretrofitroom.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vj.mvvmretrofitroom.models.QuoteList
import com.vj.mvvmretrofitroom.repository.QuoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(val quoteRepository: QuoteRepository):ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            quoteRepository.getQuotes(1)
        }


    }
    val quotes:LiveData<QuoteList>
      get() =   quoteRepository.quotes

}