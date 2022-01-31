package com.example.e3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.button.MaterialButton

class ShowElect : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_elect)

        val data = DataElectrodomesticos()
        val electrodomesticos = data.loadData(this)
        var message="Total de electrodomésticos: ${electrodomesticos.total}\n\n"

        for (i in (1..electrodomesticos.total)){
            message+=electrodomesticos.getElect(i-1).getData()
        }


        findViewById<TextView>(R.id.info).text = message


        //------------------------------------Back
        findViewById<MaterialButton>(R.id.btn_back).setOnClickListener {
            Intent(this, MainActivity::class.java).also {
                startActivity(it)
            }
        }



    }
}