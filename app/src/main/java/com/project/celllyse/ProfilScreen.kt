package com.project.celllyse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.project.celllyse.databinding.LandingScreenBinding
import com.project.celllyse.databinding.ProfileScreenBinding
import com.project.celllyse.databinding.RiwayatScreenBinding

public class ProfilScreen : AppCompatActivity() {

    lateinit var binding : ProfileScreenBinding
    public override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ProfileScreenBinding.inflate(layoutInflater)

        setContentView(binding.root)


        binding.btnEdtProfil.setOnClickListener {
            startActivity(Intent(this, EditProfilScreen::class.java))
        }

    }




    }

