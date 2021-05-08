package com.emirgazikopar.warmgame

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity2 : AppCompatActivity() {
    private lateinit var mp : MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


    }


    fun easy(view: View){
        mp=MediaPlayer.create(this@MainActivity2,R.raw.click)
        mp.start()
        var intent = Intent(applicationContext,MainActivity::class.java)
        var deger = 0
        intent.putExtra("value",deger.toInt())
        finish()
        startActivity(intent)


    }
    fun medium(view: View){
        mp=MediaPlayer.create(this@MainActivity2,R.raw.click)
        mp.start()
        var intent = Intent(applicationContext,MainActivity::class.java)
        var deger = 1
        intent.putExtra("value",deger.toInt())
        finish()
        startActivity(intent)
    }
    fun hard(view:View){
        mp=MediaPlayer.create(this@MainActivity2,R.raw.click)
        mp.start()
        var intent = Intent(applicationContext,MainActivity::class.java)
        var deger = 2
        intent.putExtra("value",deger.toInt())
        finish()
        startActivity(intent)
    }
}