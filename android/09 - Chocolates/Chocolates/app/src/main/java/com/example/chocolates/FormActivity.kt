package com.example.chocolates

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class FormActivity : AppCompatActivity() {
    private lateinit var etDescricao: EditText
    private lateinit var etQuantidade: EditText
    private lateinit var btSalvar: Button
    private lateinit var btCancelar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        this.etDescricao = findViewById(R.id.etFormDescricao)
        this.etQuantidade = findViewById(R.id.etFormQuantidade)
        this.btSalvar = findViewById(R.id.btFormSalvar)
        this.btCancelar = findViewById(R.id.btFormCancelar)

        this.btSalvar.setOnClickListener({ salvar() })
        this.btCancelar.setOnClickListener({ cancelar() })
    }

    fun salvar(){
        val descricao = this.etDescricao.text.toString()
        val qtde = this.etQuantidade.text.toString().toInt()
        val chocolate = Chocolate(descricao, qtde)
        val intent = Intent().apply {
            putExtra("CHOCOLATE", chocolate)
        }
        setResult(RESULT_OK, intent)
        finish()
    }

    fun cancelar(){
        finish()
    }
}