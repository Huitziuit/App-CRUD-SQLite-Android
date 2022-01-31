package com.example.e3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class UpdateElect : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_elect)
        findViewById<MaterialButton>(R.id.btn_back).setOnClickListener {
            Intent(this, MainActivity::class.java).also {
                startActivity(it)
            }
        }

        findViewById<MaterialButton>(R.id.btn_update).setOnClickListener {
            val index = findViewById<TextInputEditText>(R.id.id_elect).text.toString().toInt()

            val nombre = findViewById<TextInputEditText>(R.id.nombre_elec).text.toString()
            val potencia = findViewById<TextInputEditText>(R.id.potencia_elec).text.toString().toInt()
            val horas = findViewById<TextInputEditText>(R.id.horas_elec).text.toString().toInt()
            val conectado = findViewById<CheckBox>(R.id.CB_siempre_conectado).isChecked.toString()
            val upElect = Electrodomestico(nombre,potencia,horas,conectado)
            upElect.setId(index)

            val data = DataElectrodomesticos()
            data.updateForIndex(this,upElect)

        }

    }
}