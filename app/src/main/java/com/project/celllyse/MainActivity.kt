//package com.project.celllyse
//
//import android.content.Intent
//import android.os.Bundle
//import androidx.appcompat.app.AppCompatActivity
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import com.google.firebase.auth.FirebaseAuth
//
//class MainActivity : AppCompatActivity() {
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        val auth = FirebaseAuth.getInstance()
//        val currentUser = auth.currentUser
//        if (currentUser != null) {
//            intent = Intent(this, BerandaScreen::class.java);
//            startActivity(intent)
//            finish()
//        }else {
//            val intent = Intent(this, LandingScreen::class.java);
//            startActivity(intent)
//            finish()
//            }
//        }
//
//}

package com.project.celllyse

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Remove Firebase authentication check

        // Instead, directly start the activity you want
        val intent = Intent(this, LandingScreen::class.java)
        startActivity(intent)
        finish()
    }
}
