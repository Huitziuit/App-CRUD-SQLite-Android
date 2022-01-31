package com.example.e3

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class mySQLiteHelper(context: Context) : SQLiteOpenHelper(context, "electrodomesticos.db",null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        val ordenCreacion="CREATE TABLE electrodomesticos" +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nombre TEXT, potencia TEXT, horas TEXT, conectado TEXT)"

        db!!.execSQL(ordenCreacion)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val ordenBorrado = "DROP TABLE IF EXISTS electrodomesticos"
        db!!.execSQL(ordenBorrado)
        onCreate(db)
    }

    fun addData(nombre:String, potencia:String, horas:String, conectado:String){
        val datos = ContentValues()
        datos.put("nombre", nombre)
        datos.put("potencia", potencia)
        datos.put("horas", horas)
        datos.put("conectado", conectado)


        val db = this.writableDatabase
        db.insert("electrodomesticos",null, datos)

        db.close()

    }

    fun deleteData(ID:Int){
        val args= arrayOf(ID.toString())
        val db = this.writableDatabase
        db.execSQL("DELETE FROM electrodomesticos WHERE id = ?",args)
        db.close()
    }

    fun UpdateData(ID: Int, nombre:String, potencia:String, horas:String, conectado:String){
        val args = arrayOf(ID.toString())

        val datos = ContentValues()
        datos.put("nombre", nombre)
        datos.put("potencia", potencia)
        datos.put("horas", horas)
        datos.put("conectado", conectado)


        val db = this.writableDatabase
        db.update("electrodomesticos",datos, "id = ?",args)

        db.close()

    }

}