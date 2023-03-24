package com.example.fofoca

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton

class FormActivity : AppCompatActivity() {
    private lateinit var etDescricao: EditText
    private lateinit var rbVerdade: RadioButton
    private lateinit var rbMentira: RadioButton
    private lateinit var btnSalvar: Button
    private lateinit var btnCancelar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        this.etDescricao = findViewById(R.id.etFormDescricao)
        this.rbVerdade = findViewById(R.id.rbFormVerdade)
        this.rbMentira = findViewById(R.id.rbFormMentira)
        this.btnSalvar = findViewById(R.id.btnFormSalvar)
        this.btnCancelar = findViewById(R.id.btnFormCancelar)

        this.btnSalvar.setOnClickListener({ salvar() })
        this.btnCancelar.setOnClickListener({ cancelar() })
    }

    fun salvar(){

    }

    fun cancelar(){

    }
}