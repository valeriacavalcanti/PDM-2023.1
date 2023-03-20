package com.example.telas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.button = findViewById(R.id.buttonMain)
//        this.button.setOnClickListener({ chamarOutra() })

        val outraResposta = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if (it.resultCode == RESULT_OK){
                val msg = it.data?.getStringExtra("RESPOSTA")
                Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Cancelou", Toast.LENGTH_SHORT).show()
            }
        }

        this.button.setOnClickListener({
            val intent = Intent(this, OutraActivity::class.java)
            outraResposta.launch(intent)
        })

        Log.i("APP_TELA", "Main - onCreate")
    }

    override fun onStart() {
        super.onStart()

        Log.i("APP_TELA", "Main - onStart")
    }

    override fun onRestart() {
        super.onRestart()

        Log.i("APP_TELA", "Main - onRestart")
    }

    override fun onResume() {
        super.onResume()

        Log.i("APP_TELA", "Main - onResume")
    }

    override fun onPause() {
        super.onPause()

        Log.i("APP_TELA", "Main - onPause")
    }

    override fun onStop() {
        super.onStop()

        Log.i("APP_TELA", "Main - onStop")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.i("APP_TELA", "Main - onDestroy")
    }

    fun chamarOutra(){
        val intent = Intent(this, OutraActivity::class.java)
        intent.putExtra("MSG", "Funciona!")
        startActivity(intent)
    }
}