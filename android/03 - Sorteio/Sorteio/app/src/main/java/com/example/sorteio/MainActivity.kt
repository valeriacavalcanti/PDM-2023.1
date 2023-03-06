package com.example.sorteio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var etTexto: EditText
    private lateinit var btnCadastrar: Button
    private lateinit var btnSortear: Button
    private lateinit var tvResultado: TextView
    private lateinit var cadastro: Cadastro

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.cadastro = Cadastro()

        this.etTexto = findViewById(R.id.etTexto)
        this.btnCadastrar = findViewById(R.id.btnCadastrar)
        this.btnSortear = findViewById(R.id.btnSortear)
        this.tvResultado = findViewById(R.id.tvResultado)

        this.btnCadastrar.setOnClickListener({ cadastrar() })
        this.btnSortear.setOnClickListener({ sortear() })
    }

    fun cadastrar(){
        val texto = this.etTexto.text.toString()
        this.cadastro.add(texto)
        Log.i("APP_SORTEIO", this.cadastro.lista.toString())
        this.etTexto.text.clear()
    }

    fun sortear(){
        val texto = this.cadastro.sorteio()
        if (texto == null){
            Toast.makeText(this, "epa", Toast.LENGTH_SHORT).show()
        }else{
            this.tvResultado.text = texto
        }
    }
}