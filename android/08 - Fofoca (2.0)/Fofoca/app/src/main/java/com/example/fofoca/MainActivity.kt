package com.example.fofoca

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    private lateinit var btnJogar: Button
    private lateinit var btnCadastrar: Button
    private lateinit var tvQuantidade: TextView
    private var cadastro: Cadastro

    init {
        this.cadastro = Cadastro()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.btnJogar = findViewById(R.id.btnMainJogar)
        this.btnCadastrar = findViewById(R.id.btnMainCadastrar)
        this.tvQuantidade = findViewById(R.id.tvMainQuantidade)

        this.tvQuantidade.text = "${this.cadastro.size()} fofoca(s) cadastrada(s)."

        var formResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if (it.resultCode == RESULT_OK){
                val fofoca = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    it.data?.getSerializableExtra("FOFOCA", Fofoca::class.java)
                } else {
                    it.data?.getSerializableExtra("FOFOCA")
                } as Fofoca
                this.cadastro.add(fofoca)
                this.tvQuantidade.text = "${this.cadastro.size()} fofoca(s) cadastrada(s)."
                Toast.makeText(this, "Cadastrada com sucesso!", Toast.LENGTH_SHORT).show()
            }
        }

        var jogoResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if (it.resultCode == RESULT_OK){
                Toast.makeText(this, "Ganhou!", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Perdeu!", Toast.LENGTH_SHORT).show()
            }
        }

        this.btnCadastrar.setOnClickListener({
            val intent = Intent(this, FormActivity::class.java)
            formResult.launch(intent)
        })

        this.btnJogar.setOnClickListener({
            val fofoca = this.cadastro.get()
            val intent = Intent(this, JogoActivity::class.java).apply {
                putExtra("FOFOCA", fofoca)
            }
            jogoResult.launch(intent)
        })
    }

}