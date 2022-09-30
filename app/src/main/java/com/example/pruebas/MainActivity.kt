package com.example.pruebas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.math.RoundingMode
import kotlin.math.round

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main()
    }

     fun main(){

        //COGEMOS TODAS LAS VARIABLES DE LAS VISTAS

        var numero1 = findViewById<TextView>(R.id.numero1)
        var numero2 = findViewById<TextView>(R.id.numero2)

        var error = findViewById<TextView>(R.id.error)

        val sumar = findViewById<TextView>(R.id.botonSuma)
        val restar = findViewById<TextView>(R.id.botonResta)
        val multiplicar = findViewById<TextView>(R.id.botonMult)
        val dividir = findViewById<TextView>(R.id.botonDiv)

        var resultado = findViewById<TextView>(R.id.resultado)

        val resetear = findViewById<Button>(R.id.reset)

         //COMPROBACION DE INPUT DE NUMERO VACIO

         fun nullCheck(a: String, b:String): Boolean{
             if(a.equals("") || b.equals("")){
                 return true
             }
             return false
         }

        //REALIZAMOS UNA FUNCION PARA CADA OPERACION

        fun suma(a:Double, b:Double):Double{
            return a+b
        }

        fun resta(a:Double, b:Double):Double{
            return a-b
        }

        fun multiplicacion(a:Double, b:Double):Double{
            return a*b
        }

        fun division(a:Double, b:Double):Double{
            return a/b
        }

        //CREAMOS EL LISTENER QUE VA A ESCUCHAR A QUE BOTON PULSAMOS

        sumar.setOnClickListener(){
            if(nullCheck(numero1.text.toString(), numero2.text.toString())){
                error.setText("Introduce ambos numeros para operar")
            }else{
                var num1 = numero1.text.toString().toDouble()
                var num2 = numero2.text.toString().toDouble()
                resultado.text = ((suma(num1, num2).toBigDecimal().setScale(3, RoundingMode.HALF_UP).toDouble()).toString())
                error.setText("")
            }

        }

         restar.setOnClickListener(){
             if(nullCheck(numero1.text.toString(), numero2.text.toString())){
                 error.setText("Introduce ambos numeros para operar")
             }else{
                 var num1 = numero1.text.toString().toDouble()
                 var num2 = numero2.text.toString().toDouble()
                 resultado.text = ((resta(num1, num2).toBigDecimal().setScale(3, RoundingMode.HALF_UP).toDouble()).toString())
                 error.setText("")
             }
         }

         multiplicar.setOnClickListener(){
             if(nullCheck(numero1.text.toString(), numero2.text.toString())){
                 error.setText("Introduce ambos numeros para operar")
             }else{
                 var num1 = numero1.text.toString().toDouble()
                 var num2 = numero2.text.toString().toDouble()
                 resultado.text = ((multiplicacion(num1, num2).toBigDecimal().setScale(3, RoundingMode.HALF_UP).toDouble()).toString())
                 error.setText("")
             }
         }

         dividir.setOnClickListener(){
             if(nullCheck(numero1.text.toString(), numero2.text.toString())){
                 error.setText("Introduce ambos numeros para operar")
             }else{
                 var num1 = numero1.text.toString().toDouble()
                 var num2 = numero2.text.toString().toDouble()
                 if(num2==0.0){
                     error.setText("Cualquier número entre 0 es infinito")
                 }else{
                     resultado.text = ((division(num1, num2).toBigDecimal().setScale(3, RoundingMode.HALF_UP).toDouble()).toString())
                     error.setText("")
                 }
             }
         }

         //CREAMOS EL BOTON DE RESET

         resetear.setOnClickListener(){
             numero1.setText("")
             numero2.setText("")

             resultado.text = ""
             error.text=""
         }
    }
}