package br.com.mvvm.myapplication.ui.quotes

import androidx.lifecycle.ViewModel
import br.com.mvvm.myapplication.data.Quote
import br.com.mvvm.myapplication.data.QuoteRepository

class QuotesViewModel(private val quoteRepository: QuoteRepository): ViewModel() {

    fun getQuotes() = quoteRepository.getQuotes()

    fun addQuote(quote: Quote) = quoteRepository.addQuote(quote)

}