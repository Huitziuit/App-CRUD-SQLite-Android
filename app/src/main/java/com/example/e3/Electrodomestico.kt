package com.example.e3

data class Electrodomestico (var nombre:String, val potencia: Int, val horas: Int, val conectado:String){

    var ID: Int=0
    fun getData():String{
        var info=""
        info+="ID: $ID \n"
        info+="Dispositivo: $nombre \n"
        info+="Potencia : $potencia W\n"
        info+="Horas de uso al dia: $horas \n"
        info+="Permanece conectado: $conectado \n"
        var gasto:Float=(potencia.toFloat()/1000)*30
        if(conectado=="true"){
            gasto += ((10 * gasto) / 100)
        }
        var gastoRound:Double = String.format("%.3f", gasto).toDouble()
        info+="Gasto al mes: $gastoRound Kwh\n\n\n"

        return info
    }

    fun setId(id:Int){
        this.ID=id
    }
}