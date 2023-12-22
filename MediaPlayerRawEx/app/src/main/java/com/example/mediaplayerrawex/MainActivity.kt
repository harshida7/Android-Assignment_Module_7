package com.example.mediaplayerrawex


import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {


    lateinit var btn3 : Button
    lateinit var mediaPlayer: MediaPlayer
    lateinit var btn4 : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btn3 = findViewById(R.id.btnPlay)
        btn4 = findViewById(R.id.btnStop1)

        mediaPlayer = MediaPlayer.create(applicationContext,R.raw.ram_siya_ram)


        btn3.setOnClickListener {
            mediaPlayer.start()

        }

        btn4.setOnClickListener {
            mediaPlayer.stop()

        }

    }
}