package com.example.clicount

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    private lateinit var btAdd: Button
    private lateinit var lvInstituicoes: ListView
    private lateinit var dao: InstituicaoDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.dao = InstituicaoDAO(this)

        this.btAdd = findViewById(R.id.btAdd)
        this.lvInstituicoes = findViewById(R.id.lvInstituicao)

        this.lvInstituicoes.adapter = ArrayAdapter<Instituicao>(this, android.R.layout.simple_list_item_1, this.dao.get())

        this.btAdd.setOnClickListener({ add() })
    }

    fun add(){
        val instituicao = Instituicao("IFPB")
        this.dao.add(instituicao)
        this.lvInstituicoes.adapter = ArrayAdapter<Instituicao>(this, android.R.layout.simple_list_item_1, this.dao.get())
    }
}