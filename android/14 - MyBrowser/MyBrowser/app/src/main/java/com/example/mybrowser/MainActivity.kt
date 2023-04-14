package com.example.mybrowser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var etUrl: EditText
    private lateinit var btVai: Button
    private lateinit var wvHtml: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.etUrl = findViewById(R.id.etHttp)
        this.btVai = findViewById(R.id.btVai)
        this.wvHtml = findViewById(R.id.wvHtml)

        this.btVai.setOnClickListener({ vai() })

        this.wvHtml.webViewClient = WebViewClient()

        if (intent.data != null){
            this.wvHtml.loadUrl(intent.data.toString())
        }
    }

    fun vai(){
        val url = this.etUrl.text.toString()
        this.wvHtml.loadUrl(url)
    }
}