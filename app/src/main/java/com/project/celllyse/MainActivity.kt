package com.project.celllyse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Check if the activity is using the layout version with
        // the fragment_container FrameLayout. If so, we must add the first fragment
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.prediksifrag, PrediksiFragment())
                .commit()
        }
    }
}
