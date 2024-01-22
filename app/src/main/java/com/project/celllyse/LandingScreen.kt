package com.project.celllyse
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.project.celllyse.RegisterScreen
import com.project.celllyse.databinding.LandingScreenBinding

public class LandingScreen : AppCompatActivity() {

    lateinit var binding : LandingScreenBinding
    public override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)

        binding = LandingScreenBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btnDaftar.setOnClickListener {
        startActivity(Intent(this, RegisterScreen::class.java))
    }




    }
}
