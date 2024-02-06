package com.example.exampleintent

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.exampleintent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var _binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)

//        _binding.btnGo.setOnClickListener {
//            Intent(Intent.ACTION_MAIN).also {
//                it.`package` = "com.google.android.youtube"
//                startActivity(it)
//            }
//        }

        _binding.btnSend.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_EMAIL, arrayOf(_binding.ETEmail.text.toString()))
                putExtra(Intent.EXTRA_SUBJECT, "Hello")
                putExtra(Intent.EXTRA_TEXT, "Hi!!!")
            }

            intent.resolveActivity(packageManager)?.let { startActivity(intent) }
        }
    }
}