package com.example.e3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        findViewById<MaterialButton>(R.id.btn_add).setOnClickListener {
            Intent(this, AddElect::class.java).also {
                startActivity(it)
            }
        }

        findViewById<MaterialButton>(R.id.btn_delete).setOnClickListener {
            Intent(this, DeleteElect::class.java).also {
                startActivity(it)
            }
        }

        findViewById<MaterialButton>(R.id.btn_update).setOnClickListener {
            Intent(this, UpdateElect::class.java).also {
                startActivity(it)
            }
        }

        findViewById<MaterialButton>(R.id.btn_load).setOnClickListener {
            Intent(this, ShowElect::class.java).also {
                startActivity(it)
            }
        }


    }
}