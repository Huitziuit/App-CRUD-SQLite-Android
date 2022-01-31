package com.example.e3

class Electrodomesticos {

    var total:Int=0
    val listE = mutableListOf<Electrodomestico>()

    fun add(electrodomestico: Electrodomestico){
        listE.add(electrodomestico)
        total++
    }

    fun getElect(index: Int):Electrodomestico{
        return listE[index]
    }

    fun delete(index: Int){
        if(index<=total) {
            listE.removeAt(index - 1)
            total--
        }
    }

    fun update(index: Int, electrodomestico:Electrodomestico){
        if(index<=total){
            listE[index-1]=electrodomestico
        }
    }
}