package com.example.mediaplayerserver

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mediaplayerserver.databinding.ActivityFullScreenBinding
import com.example.mediaplayerserver.databinding.ActivitySongsListViewBinding
import com.squareup.picasso.Picasso

class FullScreenActivity : AppCompatActivity(), MediaPlayer.OnPreparedListener {

   // var url = "https://compressible-approa.000webhostapp.com/MediaPlayer_API/songs/"
    var mediaPlayer: MediaPlayer = MediaPlayer()
    private lateinit var binding: ActivityFullScreenBinding

    var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFullScreenBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var i = intent
      var pos =   i.getIntExtra("mypos",101)
      var song =   i.getStringExtra("songname")
      var singer =   i.getStringExtra("singernm")
      var img =   i.getStringExtra("img")

        binding.txtSongNm.setText(song)
        binding.txtSingerNm.setText(singer)
       Picasso.get().load(img).placeholder(R.drawable.musicplayer).into(binding.imgSong)

        if (pos == 0)
        {

            mediaPlayer.setDataSource("https://compressible-approa.000webhostapp.com/MediaPlayer_API/songs/12%20Ladke.mp3")

        }
         if (pos == 1)
        {
            mediaPlayer.setDataSource("https://compressible-approa.000webhostapp.com/MediaPlayer_API/songs/Bob%20Marley%20Om%20Namah%20Shivaya%20(Remix).mp3")

        }
         if (pos == 2)
        {
            mediaPlayer.setDataSource("https://compressible-approa.000webhostapp.com/MediaPlayer_API/songs/Copines.mp3")

        }
         if (pos == 3)
        {
            mediaPlayer.setDataSource("https://compressible-approa.000webhostapp.com/MediaPlayer_API/songs/Dard%20Hua.mp3")
        }
         if (pos == 4)
        {
            mediaPlayer.setDataSource("https://compressible-approa.000webhostapp.com/MediaPlayer_API/songs/Dil%20Deewana%20Kehta%20Hai.mp3")
        }
         if (pos == 5)
        {
            mediaPlayer.setDataSource("https://compressible-approa.000webhostapp.com/MediaPlayer_API/songs/Hum%20Nahin.mp3")
        }
         if (pos == 6)
        {
            mediaPlayer.setDataSource("https://compressible-approa.000webhostapp.com/MediaPlayer_API/songs/Jhoome%20Jo%20Pathaan.mp3")
        }
         if (pos == 7)
        {
            mediaPlayer.setDataSource("https://compressible-approa.000webhostapp.com/MediaPlayer_API/songs/Kabhi%20Shaam%20Dhale.mp3")
        }
         if (pos == 8)
        {
            mediaPlayer.setDataSource("https://compressible-approa.000webhostapp.com/MediaPlayer_API/songs/Kitni%20Bechain%20Hoke.mp3")
        }
         if (pos == 9)
        {
            mediaPlayer.setDataSource("https://compressible-approa.000webhostapp.com/MediaPlayer_API/songs/Unstoppable.mp3")
        }

        else{
            Toast.makeText(applicationContext, "Choose Validd Song", Toast.LENGTH_SHORT).show()
        }
        mediaPlayer.prepareAsync()
        mediaPlayer.setOnPreparedListener(this)

        Toast.makeText(applicationContext, "Start   " + pos  , Toast.LENGTH_SHORT).show()
        binding.btnPlay.setOnClickListener {

           if(mediaPlayer != null && mediaPlayer.isPlaying)
           {
               mediaPlayer.pause()
               binding.btnPlay.setImageResource(R.drawable.pause)
           }
            else
           {
               mediaPlayer.start()
               binding.btnPlay.setImageResource(R.drawable.plays)
           }
        }

        binding.btnNext.setOnClickListener {
            Toast.makeText(applicationContext, "Next", Toast.LENGTH_SHORT).show()
        }
        binding.btnPrevious.setOnClickListener {

            Toast.makeText(applicationContext, "Previous", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onPrepared(mp: MediaPlayer?) {
        mediaPlayer.start()
    }
}