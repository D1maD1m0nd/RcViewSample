package com.example.rcviewsample

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ImageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)
        findViewById<TextView>(R.id.imageTweetContent).text =
            intent.extras?.getString("Url") ?: "Profile Image"
    }
}