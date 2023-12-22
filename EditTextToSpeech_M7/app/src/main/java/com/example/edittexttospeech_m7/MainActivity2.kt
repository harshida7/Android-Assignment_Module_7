package com.example.edittexttospeech_m7

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.wifi.WifiManager
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.example.edittexttospeech_m7.databinding.ActivityMain2Binding
import com.example.edittexttospeech_m7.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {

    private  lateinit var binding: ActivityMain2Binding



    private lateinit var wifiManager: WifiManager

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        wifiManager = applicationContext
            .getSystemService(Context.WIFI_SERVICE) as WifiManager

        binding.btnWifiOn.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                val panelIntent = Intent(Settings.Panel.ACTION_WIFI)
                startActivity(panelIntent)
            } else {
                if (!wifiManager.isWifiEnabled) {
                    wifiManager.isWifiEnabled = true
                    binding.btnWifiOn.text = "Turn WiFi ON"
                } else {
                    wifiManager.isWifiEnabled = false
                    binding.btnWifiOn.text = "Turn WiFi OFF"
                }
            }
        }

        if (wifiManager.isWifiEnabled) {
            binding.imgWifi.setImageDrawable(
                ResourcesCompat.getDrawable(
                    resources,
                    R.drawable.baseline_wifi_24,
                    applicationContext.theme
                )
            )

            binding.btnWifiOn.text = "Turn WiFi Off"
        } else {
            binding.imgWifi.setImageDrawable(
                ResourcesCompat.getDrawable(
                    resources,
                    R.drawable.baseline_wifi_off_24,
                    applicationContext.theme
                )
            )

            binding.btnWifiOn.text = "Turn WiFi On"
        }
    }

    override fun onResume() {
        super.onResume()
        if (wifiManager.isWifiEnabled) {
            binding.imgWifi.setImageDrawable(
                ResourcesCompat.getDrawable(
                    resources,
                    R.drawable.baseline_wifi_24,
                    applicationContext.theme
                )
            )

            binding.btnWifiOn.text = "Turn WiFi Off"
        } else {
            binding.imgWifi.setImageDrawable(
                ResourcesCompat.getDrawable(
                    resources,
                    R.drawable.baseline_wifi_off_24,
                    applicationContext.theme
                )
            )

            binding.btnWifiOn.text = "Turn WiFi On"
        }
    }
}
