package com.example.chocolatebaseadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.AdapterView.OnItemLongClickListener
import android.widget.ListView
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var lvNomes: ListView
    private lateinit var fabAdd: FloatingActionButton
    private var nomes: MutableList<String>

    init {
        this.nomes = mutableListOf()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.lvNomes = findViewById(R.id.lvPessoas)
        this.fabAdd = findViewById(R.id.fabAdd)

        this.lvNomes.adapter = ChocolateAdapter(this, this.nomes)

        this.fabAdd.setOnClickListener({ add() })

        this.lvNomes.setOnItemClickListener( OnItemClick() )
        this.lvNomes.setOnItemLongClickListener( OnItemLongClick() )
    }

    fun add(){
        val nome = "Chocolate ${this.nomes.size + 1}"
        (this.lvNomes.adapter as ChocolateAdapter).add(nome)
    }

    inner class OnItemClick: OnItemClickListener{
        override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            val nome = this@MainActivity.nomes.get(position)
            Toast.makeText(this@MainActivity, nome, Toast.LENGTH_SHORT).show()
        }
    }

    inner class OnItemLongClick: OnItemLongClickListener{
        override fun onItemLongClick(
            parent: AdapterView<*>?,
            view: View?,
            position: Int,
            id: Long,
        ): Boolean {
            (this@MainActivity.lvNomes.adapter as ChocolateAdapter).del(position)
            return true
        }

    }
}