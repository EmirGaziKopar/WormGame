package com.emirgazikopar.warmgame

import android.content.Intent
import android.media.MediaPlayer
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import java.util.Random
import java.lang.Math.random

class MainActivity : AppCompatActivity() {
    var score = 0
    var imageArray = ArrayList<ImageView>()
    var handler : Handler = Handler(Looper.getMainLooper()) //handler ve runnableyi tanımladık
    var runnable = Runnable {  }
    var sayac = 0
    var derece = 0 //zorluk seviyesini ayarlamak için



    private lateinit var mp : MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intentAl = intent

       derece = intentAl.getIntExtra("value",0)

        imageArray.add(imageView)
        imageArray.add(imageView1)
        imageArray.add(imageView2)
        imageArray.add(imageView3)
        imageArray.add(imageView4)
        imageArray.add(imageView5)
        imageArray.add(imageView6)
        imageArray.add(imageView7)
        imageArray.add(imageView8)
        imageArray.add(imageView9)
        imageArray.add(imageView10)
        imageArray.add(imageView11)
        imageArray.add(imageView12)
        imageArray.add(imageView13)
        imageArray.add(imageView14)
        imageArray.add(imageView15)

        //showImage()//görselleri girleyecek
        hide()

        //imageview nesnelerimizin visibilty özelliğini invisible olarak değiştirdik artık üzerlerine tıklanamaz
        //Şimdi bunları bir  dizi içersine yerleştireceğim ve loop yardımıyla random bir şekilde sadece bir tane nesneyi görünür kılıcam









        //CountDown Timer
        object : CountDownTimer(15000,1000){
            override fun onTick(millisUntilFinished: Long) {
                timeView.text = "Left: ${millisUntilFinished/1000}"

              /*  if((millisUntilFinished).toInt() == 0){
                    handler.removeCallbacks(runnable)
                } */
            // Adamlar sana onFinish() methodu koymuşlar buradaki sayaç bittikten sonra ne yapmak istersen oraya yaz diye







            }

            override fun onFinish() {
                val alert = AlertDialog.Builder(this@MainActivity)
                handler.removeCallbacks(runnable)
                mp.stop()

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
                alert.setCancelable(false)
                alert.setPositiveButton("yes") {dialog, which->
                    val intent = intent //normal şartlarda sayfalardan veri çekmek veya gideceğimiz aktiviteyi belirtip aktiviteler arası yolculuk için kullanırız ama bu şekilde kullanıldığında olduğu aktivititeye
                    //tekrar gidiyor
                    finish() //burada aktiviteyi sonlandırıyoruz çünkü birazdan tekarar gireceğiz
                    startActivity(intent)
                }
                alert.setNegativeButton("No"){dialog, Which->
                    Toast.makeText(this@MainActivity,"GameOver",Toast.LENGTH_SHORT).show()
                    sayac=1
                    handler.removeCallbacks(runnable)//runnable durur tabi handler'da


                }
                alert.show()

            }

        }.start()
    }

    override fun onResume() {
        super.onResume()
        mp=MediaPlayer.create(this,R.raw.arkaplan)
        mp.start()
    }


    fun next(view :View){
        handler.removeCallbacks(runnable)
        mp.stop()
        var intent = Intent(applicationContext,MainActivity2::class.java)
        finish()
        startActivity(intent)



    }



    fun start (view : View){
        if(sayac==1){
            val intent = intent
            finish()
            startActivity(intent)

        }


    }
    fun scoreUp (view : View){
        score+=1
        scoreView.text = "Skore: ${score}"
        mp=MediaPlayer.create(this,R.raw.vicik)
        mp.start()

    }


    fun hide(){//Burada array içersindeki bütün imageView'leri sakladık ve içlerinden birisini random gösterme işlemini yaptık

        runnable = object : Runnable {
            override fun run() {
                /*handler.removeCallbacks(runnable)
                mp.stop()*/
                //bunun içine yazılan herşey istediğimiz periyotta çalıştırılır
                for (image in imageArray){
                    image.visibility = View.INVISIBLE
                }
                val random = Random()
                val randomIndex = random.nextInt(16)

                imageArray[randomIndex].visibility = View.VISIBLE

                if(derece==2){//zor
                    handler.postDelayed(runnable,200)//burada belirlenen süre bir birim frekansın süresi yani ne kadar kısa verirsek oyun o kadar zor olur
                }
                if(derece==1){//orta
                    handler.postDelayed(runnable,500)//Orta
                }
                if (derece==0){//kolay
                    handler.postDelayed(runnable,800)//Kolay
                }

            }

        }
        handler.post(runnable) //runnableyi çalıştıran kod


    }








}