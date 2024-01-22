package com.project.celllyse

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth

class RegisterScreen : AppCompatActivity() {
    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnDaftar: Button
    private lateinit var loginReg: TextView
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_screen)

        etUsername = findViewById(R.id.input_name)
        etPassword = findViewById(R.id.input_pass)
        btnDaftar = findViewById(R.id.btn_daftar)
        loginReg = findViewById(R.id.txt_login2)
        mAuth = FirebaseAuth.getInstance()

        loginReg.setOnClickListener {
            startActivity(Intent(this@RegisterScreen, LoginScreen::class.java))
        }

        btnDaftar.setOnClickListener {
            val username = etUsername.text.toString().trim()
            val password = etPassword.text.toString().trim()

            // Memeriksa apakah username dan password kosong
            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this@RegisterScreen, "Mohon isi semua kolom", Toast.LENGTH_SHORT)
                    .show()
            } else {
                // Lanjutkan dengan proses autentikasi atau tindakan lainnya
                Toast.makeText(this@RegisterScreen, "Proses autentikasi...", Toast.LENGTH_SHORT)
                    .show()

                mAuth.createUserWithEmailAndPassword(username, password)
                    .addOnCompleteListener(object : OnCompleteListener<AuthResult> {
                        override fun onComplete(task: Task<AuthResult>) {
                            if (task.isSuccessful) {
                                Toast.makeText(
                                    this@RegisterScreen,
                                    "Akun berhasil terbuat!",
                                    Toast.LENGTH_SHORT
                                ).show()
                                val intent = Intent(this@RegisterScreen,LoginScreen::class.java)
                                startActivity(intent)
                                finish()
                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(
                                    this@RegisterScreen,
                                    "Authentication failed: ${task.exception?.message}",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    })
            }
        }
    }

    override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = mAuth.currentUser
        if (currentUser != null) {
            val intent = Intent(this@RegisterScreen, LoginScreen::class.java)
            startActivity(intent)
            finish()
        }
    }}