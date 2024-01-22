package com.project.celllyse

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
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

class LoginScreen : AppCompatActivity() {
    private lateinit var Username: EditText
    private lateinit var Password: EditText

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var mAuth: FirebaseAuth

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = mAuth.currentUser
        if (currentUser != null) {
            moveToNextPage()
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_screen)

        mAuth = FirebaseAuth.getInstance()

        Username = findViewById(R.id.input_name)
        Password = findViewById(R.id.input_pass)
        val Login = findViewById<Button>(R.id.btn_login)
        val Signup = findViewById<TextView>(R.id.txt_daftar)

        sharedPreferences = getSharedPreferences("userData", Context.MODE_PRIVATE)


        Signup.setOnClickListener {
            val intent = Intent(this@LoginScreen, RegisterScreen::class.java)
            startActivity(intent)
            finish()
        }

        Login.setOnClickListener {
            val username = Username.text.toString().trim()
            val password = Password.text.toString().trim()

            // Memeriksa apakah username, email, dan password kosong
            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this@LoginScreen, "Mohon isi semua kolom", Toast.LENGTH_SHORT)
                    .show()
            } else {
                // Lanjutkan dengan proses autentikasi atau tindakan lainnya
                Toast.makeText(this@LoginScreen, "Anda Berhasil Login", Toast.LENGTH_SHORT)
                    .show()
                // ... (Tambahkan logika autentikasi atau tindakan lainnya di sini)
            }

            mAuth.signInWithEmailAndPassword(username, password)
                .addOnCompleteListener(object : OnCompleteListener<AuthResult> {
                    override fun onComplete(task: Task<AuthResult>) {
                        if (task.isSuccessful) {
                            Toast.makeText(
                                this@LoginScreen,
                                "Akun berhasil terbuat!",
                                Toast.LENGTH_SHORT
                            ).show()
                            moveToNextPage()
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(
                                this@LoginScreen,
                                "Authentication failed.",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                })
        }
    }
    private fun moveToNextPage() {
        // Pindah ke halaman Dashboard
        val intent = Intent(this@LoginScreen, BerandaScreen::class.java)
        startActivity(intent)
        finish() // Agar tidak bisa kembali ke halaman sign up setelah pindah ke halaman login
    }
}

