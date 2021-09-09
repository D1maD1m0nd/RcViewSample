package com.example.rcviewsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.rcviewsample.ui.retrofit_fragment.RetfrofitFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .add(R.id.container, RetfrofitFragment.newInstance()).commit()
    }
}