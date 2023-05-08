package com.example.clicount

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.AdapterView.OnItemLongClickListener
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast

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

//        this.lvInstituicoes.adapter = ArrayAdapter<Instituicao>(this, android.R.layout.simple_list_item_1, this.dao.get())
        this.updateListView()

        this.btAdd.setOnClickListener({ add() })

        this.lvInstituicoes.setOnItemClickListener(OnItemClick())
        this.lvInstituicoes.setOnItemLongClickListener(OnItemLongClick())
    }

    fun updateListView(){
        this.lvInstituicoes.adapter = ArrayAdapter<Instituicao>(this, android.R.layout.simple_list_item_1, this.dao.get())
    }

    fun add(){
        val instituicao = Instituicao("IFPB")
        this.dao.add(instituicao)
//        this.lvInstituicoes.adapter = ArrayAdapter<Instituicao>(this, android.R.layout.simple_list_item_1, this.dao.get())
        this.updateListView()
    }

    inner class OnItemClick: OnItemClickListener{
        override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            val inst = parent?.getItemAtPosition(position) as Instituicao
            this@MainActivity.dao.update(inst)
            this@MainActivity.updateListView()
//            Toast.makeText(this@MainActivity, inst.toString(), Toast.LENGTH_SHORT).show()
        }
    }

    inner class OnItemLongClick: OnItemLongClickListener{
        override fun onItemLongClick(
            parent: AdapterView<*>?,
            view: View?,
            position: Int,
            id: Long,
        ): Boolean {
            val inst = parent?.getItemAtPosition(position) as Instituicao
            this@MainActivity.dao.delete(inst)
            this@MainActivity.updateListView()
            return true
        }
    }
}