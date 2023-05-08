package com.example.armario

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var foneReceiver: FoneReceiver
    private lateinit var carregadorReceiver: CarregadorReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.foneReceiver = FoneReceiver()
        this.carregadorReceiver = CarregadorReceiver()
    }

    override fun onResume() {
        super.onResume()
        val ifFone = IntentFilter().apply {
            addAction(Intent.ACTION_HEADSET_PLUG)
        }

        val ifCarregador = IntentFilter().apply {
            addAction(Intent.ACTION_POWER_CONNECTED)
            addAction(Intent.ACTION_POWER_DISCONNECTED)
        }
        registerReceiver(this.foneReceiver, ifFone)
        registerReceiver(this.carregadorReceiver, ifCarregador)
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(this.foneReceiver)
        unregisterReceiver(this.carregadorReceiver)
    }

    inner class FoneReceiver: BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {
            val status = intent?.getIntExtra("state", -1)
            Toast.makeText(this@MainActivity, status.toString(), Toast.LENGTH_SHORT).show()
        }
    }

    inner class CarregadorReceiver: BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {
            if (intent?.action.equals(Intent.ACTION_POWER_CONNECTED)){
                Toast.makeText(this@MainActivity, "Conectou", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this@MainActivity, "Desconectou", Toast.LENGTH_SHORT).show()
            }
        }
    }
}