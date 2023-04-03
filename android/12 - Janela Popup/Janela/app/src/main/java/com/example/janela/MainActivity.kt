package com.example.janela

import android.content.DialogInterface
import android.content.DialogInterface.OnClickListener
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var rvNomes: RecyclerView
    private lateinit var fabAdd: FloatingActionButton
    private var lista = mutableListOf<String>()
    private lateinit var etNome: EditText
    private lateinit var tts: TextToSpeech

    init {
//        this.lista.add("Primeiro")
//        this.lista.add("Segundo")
//        this.lista.add("Terceiro")
//        this.lista.add("Quarto")
//        this.lista.add("Quinto")
//        this.lista.add("Sexto")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.rvNomes = findViewById(R.id.rvNomes)
        this.fabAdd = findViewById(R.id.fabAdd)

        this.fabAdd.setOnClickListener{ add() }

        this.rvNomes.adapter = MyAdapter(this.lista)
        (this.rvNomes.adapter as MyAdapter).onItemClickRecyclerView = OnItemClick()

        this.tts = TextToSpeech(this, null)
    }

    fun add(){
        this.etNome = EditText(this)
        val builder = AlertDialog.Builder(this).apply {
            setTitle("Novo Nome!")
            setMessage("Digite o novo nome")
            setView(this@MainActivity.etNome)
            setPositiveButton("Salvar", OnClick())
            setNegativeButton("Cancelar", null)
        }
        builder.create().show()
    }

    inner class OnClick: OnClickListener{
        override fun onClick(dialog: DialogInterface?, which: Int) {
            val nome = this@MainActivity.etNome.text.toString()
            (this@MainActivity.rvNomes.adapter as MyAdapter).add(nome)
        }
    }

    inner class OnItemClick: OnItemClickRecyclerView{
        override fun onItemClick(position: Int) {
            val nome = this@MainActivity.lista.get(position)
//            Toast.makeText(this@MainActivity, nome, Toast.LENGTH_SHORT).show()
            this@MainActivity.tts.speak(nome, TextToSpeech.QUEUE_FLUSH, null, null)
        }
    }
}