package br.com.mvvm.myapplication.utilities

import br.com.mvvm.myapplication.data.FakeDatabase
import br.com.mvvm.myapplication.data.QuoteRepository
import br.com.mvvm.myapplication.ui.quotes.QuotesViewModelFactory

object InjectorUtils {

    fun provideQuotesViewModelFactory(): QuotesViewModelFactory {
        val quoteRepository = QuoteRepository.getInstance(FakeDatabase.getInstance().quoteDao)
        return QuotesViewModelFactory(quoteRepository)
    }
}