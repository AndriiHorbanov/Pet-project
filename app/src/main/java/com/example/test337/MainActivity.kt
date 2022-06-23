package com.example.test337

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Window
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.test337.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding:ActivityMainBinding?=null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }


}