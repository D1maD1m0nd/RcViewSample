package com.example.rcviewsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rcviewsample.ui.UserSampleFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().add(R.id.container, UserSampleFragment.newInstance()).commit()
    }
}