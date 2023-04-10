package com.example.camera

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    private lateinit var btFoto: Button
    private lateinit var ivFoto: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.btFoto = findViewById(R.id.btFoto)
        this.ivFoto = findViewById(R.id.ivFoto)

//        this.btFoto.setOnClickListener({ foto() })

//        val fotoResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
//            if (it.resultCode == RESULT_OK){
//                val foto = it.data?.extras?.get("data") as Bitmap
//                this.ivFoto.setImageBitmap(foto)
//            }
//        }

//        this.btFoto.setOnClickListener({
//            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
//            fotoResult.launch(intent)
//        })

        val fotoResult = registerForActivityResult(ActivityResultContracts.TakePicturePreview()){
            this.ivFoto.setImageBitmap(it)
        }

        this.btFoto.setOnClickListener({
            fotoResult.launch(null)
        })
    }

    fun foto(){
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

        if (intent.resolveActivity(packageManager) != null){
            startActivity(intent)
        }
    }
}