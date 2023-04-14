package com.example.chamadorbrowser

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var btIFPB: Button
    private lateinit var btCabrowser: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.btIFPB = findViewById(R.id.btVer)
        this.btCabrowser = findViewById(R.id.btVerCabrowser)

        this.btIFPB.setOnClickListener({
            val uri = Uri.parse("http://www.ifpb.edu.br")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        })

        this.btCabrowser.setOnClickListener({
            val uri = Uri.parse("http://www.ifpb.edu.br")
            val intent = Intent("CABROWSER", uri)
            startActivity(intent)
        })
    }
}