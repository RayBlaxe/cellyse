package com.project.celllyse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.project.celllyse.databinding.LandingScreenBinding
import com.project.celllyse.databinding.RiwayatScreenBinding

public class RiwayatScreen : AppCompatActivity() {

    lateinit var binding : RiwayatScreenBinding
    public override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)

        binding = RiwayatScreenBinding.inflate(layoutInflater)

        setContentView(R.layout.riwayat_screen)


    }




    }

