package com.example.fofoca

import android.os.Build
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
    private lateinit var fofoca: Fofoca

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jogo)

        this.fofoca = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra("FOFOCA", Fofoca::class.java)
        } else {
            intent.getSerializableExtra("FOFOCA")
        } as Fofoca

        this.tvDescricao = findViewById(R.id.tvJogoDescricao)
        this.rbVerdade = findViewById(R.id.rbJogoVerdade)
        this.rbMentira = findViewById(R.id.rbJogoMentira)
        this.btnResponder = findViewById(R.id.btnJogoResponder)
        this.pbTempo = findViewById(R.id.pbJogoTempo)

        this.tvDescricao.text = fofoca.descricao

        this.btnResponder.setOnClickListener({ responder() })

        iniciaTempo()
    }

    fun responder(){
        if ((this.fofoca.status) && (this.rbVerdade.isChecked)){
            setResult(RESULT_OK)
        }else if ((!this.fofoca.status) && (this.rbMentira.isChecked)){
            setResult(RESULT_OK)
        }
        finish()
    }

    fun iniciaTempo(){
        Thread{
            while (this.pbTempo.progress < 100){
                this.pbTempo.progress += 1
                Thread.sleep(100)
            }
            finish()
        }.start()
    }
}