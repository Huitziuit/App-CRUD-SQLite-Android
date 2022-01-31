package com.example.e3

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.util.Log


class DataElectrodomesticos {
    lateinit var electrodomesticosDBHelper: mySQLiteHelper
    fun saveData(elec:Electrodomestico, context: Context){
        electrodomesticosDBHelper= mySQLiteHelper(context)
        electrodomesticosDBHelper.addData(elec.nombre, elec.potencia.toString(),elec.horas.toString(), elec.conectado)
    }

    fun loadData(context: Context):Electrodomesticos{
        electrodomesticosDBHelper= mySQLiteHelper(context)
        val db : SQLiteDatabase = electrodomesticosDBHelper.readableDatabase
        val cursor = db.rawQuery(
            "SELECT * FROM electrodomesticos",
            null)
        var auxElectrodomesticos= Electrodomesticos()
        if (cursor.moveToFirst()){
            do{
                var ID=cursor.getString(0).toInt()
                var nombre=cursor.getString(1).toString()
                var potencia=cursor.getString(2).toInt()
                var horas=cursor.getString(3).toInt()
                var encendido=cursor.getString(4).toString()

                var newElect= Electrodomestico(nombre,potencia,horas,encendido)
                newElect.setId(ID)
                auxElectrodomesticos.add(newElect)


            }while (cursor.moveToNext())
        }
        return auxElectrodomesticos
    }

    fun deleteForIndex(context: Context, ID:Int){
        electrodomesticosDBHelper= mySQLiteHelper(context)
        electrodomesticosDBHelper.deleteData(ID)
    }

    fun updateForIndex(context: Context, elec: Electrodomestico){
        electrodomesticosDBHelper= mySQLiteHelper(context)
        electrodomesticosDBHelper.UpdateData(elec.ID,  elec.nombre, elec.potencia.toString(),elec.horas.toString(), elec.conectado)
    }
}