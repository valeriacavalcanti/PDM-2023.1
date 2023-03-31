package com.example.chocolaterecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var rvChocolates: RecyclerView
    private lateinit var fabAdd: FloatingActionButton
    private var nomes: MutableList<String>

    init {
        this.nomes = mutableListOf()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.rvChocolates = findViewById(R.id.rvChocolates)
        this.fabAdd = findViewById(R.id.fabAdd)

        this.fabAdd.setOnClickListener({ add() })

        val adapter = ChocolateAdapter(this.nomes)
        adapter.onItemClickRecyclerView = OnItemClick()
        this.rvChocolates.adapter = adapter

        ItemTouchHelper(OnSwipe()).attachToRecyclerView(this.rvChocolates)
    }

    fun add(){
        val nome = "Chocolate ${this.nomes.size + 1}"
        (this.rvChocolates.adapter as ChocolateAdapter).add(nome)
    }

    inner class OnItemClick: OnItemClickRecyclerView{
        override fun onItemClick(position: Int) {
            val nome = this@MainActivity.nomes.get(position)
            Toast.makeText(this@MainActivity, nome, Toast.LENGTH_SHORT).show()
        }
    }

    inner class OnSwipe: ItemTouchHelper.SimpleCallback(
        ItemTouchHelper.DOWN or ItemTouchHelper.UP,
        ItemTouchHelper.START or ItemTouchHelper.END
    ) {
        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder,
        ): Boolean {
            (this@MainActivity.rvChocolates.adapter as ChocolateAdapter).mov(viewHolder.adapterPosition, target.adapterPosition)
            return true
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            (this@MainActivity.rvChocolates.adapter as ChocolateAdapter).del(viewHolder.adapterPosition)
        }
    }
}