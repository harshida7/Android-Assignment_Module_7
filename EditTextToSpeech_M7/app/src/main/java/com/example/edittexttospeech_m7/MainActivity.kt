package com.example.edittexttospeech_m7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.speech.tts.TextToSpeech.QUEUE_ADD
import com.example.edittexttospeech_m7.databinding.ActivityMainBinding
import java.util.Locale

class MainActivity : AppCompatActivity(), TextToSpeech.OnInitListener {

    private  lateinit var binding:ActivityMainBinding

    lateinit var tts: TextToSpeech

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        tts= TextToSpeech(applicationContext,this)


        binding.btnTTS.setOnClickListener {
        var edtText = binding.edtText.text.toString()

        tts.speak(edtText,QUEUE_ADD,null)
        }

        binding.btnWifi.setOnClickListener {

            startActivity(Intent(applicationContext, MainActivity2::class.java))
        }
    }

    override fun onInit(p0: Int) {
        tts.setLanguage(Locale.US)
        tts.setPitch(0.8f)
        tts.setSpeechRate(1f)
    }
}