package br.com.mvvm.myapplication.ui.quotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import br.com.mvvm.myapplication.R
import br.com.mvvm.myapplication.data.Quote
import br.com.mvvm.myapplication.utilities.InjectorUtils

class QuotesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotes)
        initializeUi()

    }

    private fun initializeUi(){
        val factory = InjectorUtils.provideQuotesViewModelFactory()
        val viewModel = ViewModelProviders.of(this,factory)[QuotesViewModel::class.java]
        val tvQuote = findViewById<TextView>(R.id.textView_quotes)
        val btn = findViewById<Button>(R.id.button_add_quote)
        val etQuote = findViewById<EditText>(R.id.editText_quote)
        val etAuthor = findViewById<EditText>(R.id.editText_author)

        viewModel.getQuotes().observe(this, Observer { quotes ->
            val stringBuilder = StringBuilder()
            quotes.forEach{ quote ->
                stringBuilder.append("$quote\n\n")
            }
            tvQuote.text = stringBuilder.toString()
        })
        btn.setOnClickListener {
            val quote = Quote(etQuote.text.toString(), etAuthor.text.toString())
            viewModel.addQuote(quote)
            etQuote.setText("")
            etAuthor.setText("")
        }

    }

}