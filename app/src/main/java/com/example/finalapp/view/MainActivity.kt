package com.example.finalapp.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.viewModels
import com.example.finalapp.R
import com.example.finalapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel.compare.observe(this){
            binding.resultCompare.text = "${it.result}"
        }

        binding.compareButton.setOnClickListener {
            val text1 = binding.firstText.text.toString()
            val text2 = binding.secondText.text.toString()

           if(text1.isEmpty() || text2.isEmpty()) {
               Toast.makeText(this, this.resources.getString(R.string.toast_error_msg) , Toast.LENGTH_LONG).show()
               binding.resultCompare.text = ""
               return@setOnClickListener}

            mainViewModel.compareStrings(text1, text2)
        }

    }
}