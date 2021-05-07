package com.emirgazikopar.warmgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var score = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //CountDown Timer
        object : CountDownTimer(30000,1000){
            override fun onTick(millisUntilFinished: Long) {
                timeView.text = "Left: ${millisUntilFinished/1000}"






            }

            override fun onFinish() {
                val alert = AlertDialog.Builder(this@MainActivity)

                if (score <10){
                    Toast.makeText(this@MainActivity,"Did you play the game with a nose?",Toast.LENGTH_LONG).show()
                }
                else if(score <20){
                    Toast.makeText(this@MainActivity,"You can do better. Use your fingers",Toast.LENGTH_LONG).show()
                }
                else if(score <30){
                    Toast.makeText(this@MainActivity,"Ordinary performance",Toast.LENGTH_LONG).show()
                }
                else if(score <40){
                    Toast.makeText(this@MainActivity,"Ordinary performance",Toast.LENGTH_LONG).show()
                }
                else if(score <50){
                    Toast.makeText(this@MainActivity,"That wasn't bad bro",Toast.LENGTH_LONG).show()
                }
                else if(score <60){
                    Toast.makeText(this@MainActivity,"Dude 2 presses per second? That was amazing ! ! ! ",Toast.LENGTH_LONG).show()
                }
                else if(score <70){
                    Toast.makeText(this@MainActivity,"Dude 2 presses per second? That was amazing ! ! ! ",Toast.LENGTH_LONG).show()
                }
                else if(score <80){
                    Toast.makeText(this@MainActivity,"What? Are you serious? This score cannot be true !!!",Toast.LENGTH_LONG).show()
                }
                else if(score >90){
                    Toast.makeText(this@MainActivity,"You are the machine right?",Toast.LENGTH_LONG).show()
                }

                alert.setTitle("Game Over")
                alert.setMessage("Do you want to play warm again ?")
                alert.setPositiveButton("yes") {dialog, which->

                }
                alert.setNegativeButton("No"){dialog, Which->
                    Toast.makeText(this@MainActivity,"GameOver",Toast.LENGTH_SHORT).show()
                }
                alert.show()

            }

        }.start()
    }

    fun scoreUp (view : View){
        score+=1
        scoreView.text = "Skore: ${score}"

    }




}