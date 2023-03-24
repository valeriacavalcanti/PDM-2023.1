package com.example.fofoca

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var btnJogar: Button
    private lateinit var btnCadastrar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.btnJogar = findViewById(R.id.btnMainJogar)
        this.btnCadastrar = findViewById(R.id.btnMainCadastrar)

    }

}