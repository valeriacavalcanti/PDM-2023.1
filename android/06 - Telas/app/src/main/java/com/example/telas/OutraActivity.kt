package com.example.telas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast

class OutraActivity : AppCompatActivity() {
    private lateinit var btnOk: Button
    private lateinit var btCancelar:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_outra)

        this.btnOk = findViewById(R.id.buttonOutraOk)
        this.btCancelar = findViewById(R.id.buttonOutraCancelar)

        this.btnOk.setOnClickListener({ salvar() })
        this.btCancelar.setOnClickListener({ cancelar() })

        Log.i("APP_TELA", "Outra - onCreate")

        if (this.intent.hasExtra("MSG")){
            val msg = this.intent.getStringExtra("MSG")
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        }
    }

    fun salvar(){
        val intent = Intent()
        intent.putExtra("RESPOSTA", "Deu certo !")
        setResult(RESULT_OK, intent)
        finish()
    }

    fun cancelar(){
        finish()
    }

    override fun onStart() {
        super.onStart()

        Log.i("APP_TELA", "Outra - onStart")
    }

    override fun onRestart() {
        super.onRestart()

        Log.i("APP_TELA", "Outra - onRestart")
    }

    override fun onResume() {
        super.onResume()

        Log.i("APP_TELA", "Outra - onResume")
    }

    override fun onPause() {
        super.onPause()

        Log.i("APP_TELA", "Outra - onPause")
    }

    override fun onStop() {
        super.onStop()

        Log.i("APP_TELA", "Outra - onStop")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.i("APP_TELA", "Outra - onDestroy")
    }
}