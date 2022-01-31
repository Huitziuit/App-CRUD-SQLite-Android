package com.example.e3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class AddElect : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_elect)

        findViewById<MaterialButton>(R.id.btn_back).setOnClickListener {
            val intent = Intent(this, MainActivity::class.java).apply{}
            startActivity(intent)
        }

        findViewById<MaterialButton>(R.id.btn_load_elec).setOnClickListener {
            val nombre = findViewById<TextInputEditText>(R.id.nombre_elec).text.toString()
            val potencia = findViewById<TextInputEditText>(R.id.potencia_elec).text.toString().toInt()
            val horas = findViewById<TextInputEditText>(R.id.horas_elec).text.toString().toInt()
            val conectado = findViewById<CheckBox>(R.id.CB_siempre_conectado).isChecked.toString()
            val newElect = Electrodomestico(nombre,potencia,horas,conectado)


            val data =DataElectrodomesticos()
            data.saveData(newElect, this)
        }
    }
}