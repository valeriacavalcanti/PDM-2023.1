package com.example.fofoca

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore.Audio.Radio
import android.widget.*
import android.widget.SeekBar.OnSeekBarChangeListener

class JogoActivity : AppCompatActivity() {
    private lateinit var tvDescricao: TextView
    private lateinit var rbVerdade: RadioButton
    private lateinit var rbMentira: RadioButton
    private lateinit var btnResponder: Button
    private lateinit var pbTempo: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jogo)

        this.tvDescricao = findViewById(R.id.tvJogoDescricao)
        this.rbVerdade = findViewById(R.id.rbJogoVerdade)
        this.rbMentira = findViewById(R.id.rbJogoMentira)
        this.btnResponder = findViewById(R.id.btnJogoResponder)
        this.pbTempo = findViewById(R.id.pbJogoTempo)

        this.btnResponder.setOnClickListener({ responder() })

        iniciaTempo()
    }

    fun responder(){

    }

    fun iniciaTempo(){

    }
}