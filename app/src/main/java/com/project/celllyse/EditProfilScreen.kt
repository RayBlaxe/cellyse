package com.project.celllyse

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.project.celllyse.databinding.BerandaScreenBinding
import com.project.celllyse.databinding.EditProfileScreenBinding
import com.project.celllyse.databinding.LandingScreenBinding
import com.project.celllyse.databinding.ProfileScreenBinding
import com.project.celllyse.databinding.RiwayatScreenBinding

public class EditProfilScreen : AppCompatActivity() {

    lateinit var binding : EditProfileScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = EditProfileScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun btnBalik(view: View) {
        startActivity(Intent(this@EditProfilScreen, ProfilScreen::class.java))
        finish()
    }




}

