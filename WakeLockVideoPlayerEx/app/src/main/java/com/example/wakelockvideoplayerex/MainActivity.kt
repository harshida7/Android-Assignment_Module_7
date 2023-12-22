package com.example.wakelockvideoplayerex

import android.annotation.SuppressLint
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PowerManager
import android.widget.MediaController
import android.widget.VideoView

class MainActivity : AppCompatActivity() {

    private lateinit var videoView: VideoView
    private var wakeLock: PowerManager.WakeLock? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        videoView = findViewById(R.id.video)
        val powerManager = getSystemService(POWER_SERVICE) as PowerManager
        wakeLock = powerManager.newWakeLock(
            PowerManager.FULL_WAKE_LOCK or PowerManager.ACQUIRE_CAUSES_WAKEUP,
            "VideoPlayerActivity:WakeLock"
        )
        wakeLock?.acquire()

        // Set the video file path
        val videoPath = "https://unaffecting-firearm.000webhostapp.com/Music%20folder/Video/Top_Falls.3gp"

        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)
        videoView.setMediaController(mediaController)

        // Set the video URI
        val videoUri = Uri.parse(videoPath)
        videoView.setVideoURI(videoUri)

        videoView.start()
    }

    override fun onDestroy() {
        super.onDestroy()

        wakeLock?.release()
    }


}