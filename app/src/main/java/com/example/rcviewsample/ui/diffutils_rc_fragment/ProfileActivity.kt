package com.example.rcviewsample.ui.diffutils_rc_fragment

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.rcviewsample.R

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        findViewById<TextView>(R.id.profileTweetContent).text =
            intent.extras?.getString("UserName") ?: "Profile UserName"
    }
}