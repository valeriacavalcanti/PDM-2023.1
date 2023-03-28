package com.example.chocolates

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.AdapterView.OnItemLongClickListener
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var lvCesta: ListView
    private lateinit var fabAdd: FloatingActionButton
    private var cesta: Cesta

    init {
        this.cesta = Cesta()
        this.cesta.add(Chocolate("Primeiro", 10))
        this.cesta.add(Chocolate("Segundo", 20))
        this.cesta.add(Chocolate("Terceiro", 30))
        this.cesta.add(Chocolate("Quarto", 40))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.lvCesta = findViewById(R.id.lvMainCesta)
        this.fabAdd = findViewById(R.id.fabMainAdd)

        var adapter = ArrayAdapter<Chocolate>(this, android.R.layout.simple_list_item_1, this.cesta.get())
        this.lvCesta.adapter = adapter

        var formResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if (it.resultCode == RESULT_OK){
                val chocolate = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    it.data?.getSerializableExtra("CHOCOLATE", Chocolate::class.java)
                } else {
                    it.data?.getSerializableExtra("CHOCOLATE")
                } as Chocolate
//                this.cesta.add(chocolate)
//                (this.lvCesta.adapter as ArrayAdapter<Chocolate>).notifyDataSetChanged()
                (this.lvCesta.adapter as ArrayAdapter<Chocolate>).add(chocolate)
                Log.i("APP_CHOCOLATES", this.cesta.get().toString())
            }
        }

        this.fabAdd.setOnClickListener({
            val intent = Intent(this, FormActivity::class.java)
            formResult.launch(intent)
        })

        this.lvCesta.setOnItemClickListener( OnItemClick() )
        this.lvCesta.setOnItemLongClickListener( OnItemLongClick() )
    }

    inner class OnItemClick: OnItemClickListener{
        override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            val chocolate = this@MainActivity.cesta.get(position)
            Toast.makeText(this@MainActivity, chocolate.toString(), Toast.LENGTH_SHORT).show()
        }
    }

    inner class OnItemLongClick: OnItemLongClickListener{
        override fun onItemLongClick(
            parent: AdapterView<*>?,
            view: View?,
            position: Int,
            id: Long,
        ): Boolean {
            this@MainActivity.cesta.del(position)
            (this@MainActivity.lvCesta.adapter as ArrayAdapter<Chocolate>).notifyDataSetChanged()
            return true
        }

    }
}