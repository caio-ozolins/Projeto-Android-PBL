package com.calculadora.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val numero_zero = findViewById<TextView>(R.id.numero_zero)
        val numero_um = findViewById<TextView>(R.id.numero_um)
        val numero_dois = findViewById<TextView>(R.id.numero_dois)
        val numero_tres = findViewById<TextView>(R.id.numero_tres)
        val numero_quatro = findViewById<TextView>(R.id.numero_quatro)
        val numero_cinco = findViewById<TextView>(R.id.numero_cinco)
        val numero_seis = findViewById<TextView>(R.id.numero_seis)
        val numero_sete = findViewById<TextView>(R.id.numero_sete)
        val numero_oito = findViewById<TextView>(R.id.numero_oito)
        val numero_nove = findViewById<TextView>(R.id.numero_nove)
        val ponto = findViewById<TextView>(R.id.ponto)

        val soma = findViewById<TextView>(R.id.soma)
        val subtracao = findViewById<TextView>(R.id.subtracao)
        val multiplicacao = findViewById<TextView>(R.id.multiplicacao)
        val divisao = findViewById<TextView>(R.id.divisao)
        val igual = findViewById<TextView>(R.id.igual)

        val limpar = findViewById<TextView>(R.id.limpar)
        val expressao = findViewById<TextView>(R.id.expressao)
        val resultado = findViewById<TextView>(R.id.resultado)
        val backspace = findViewById<ImageView>(R.id.backspace)

        numero_zero.setOnClickListener { AcrescentarUmaExpressao ( "0", true) }
        numero_um.setOnClickListener { AcrescentarUmaExpressao (  "1", true) }
        numero_dois.setOnClickListener { AcrescentarUmaExpressao (  "2", true) }
        numero_tres.setOnClickListener { AcrescentarUmaExpressao (  "3", true) }
        numero_quatro.setOnClickListener { AcrescentarUmaExpressao (  "4", true) }
        numero_cinco.setOnClickListener { AcrescentarUmaExpressao (  "5", true) }
        numero_seis.setOnClickListener { AcrescentarUmaExpressao (  "6", true) }
        numero_sete.setOnClickListener { AcrescentarUmaExpressao (  "7", true) }
        numero_oito.setOnClickListener { AcrescentarUmaExpressao (  "8", true) }
        numero_nove.setOnClickListener { AcrescentarUmaExpressao (  "9", true) }
        ponto.setOnClickListener { AcrescentarUmaExpressao(".", true) }

        //operadores
        soma.setOnClickListener { AcrescentarUmaExpressao(  "+",  false)}
        subtracao.setOnClickListener { AcrescentarUmaExpressao(  "-",  false)}
        multiplicacao.setOnClickListener { AcrescentarUmaExpressao(  "*",  false)}
        divisao.setOnClickListener { AcrescentarUmaExpressao(  "/",  false)}

        limpar.setOnClickListener {
            expressao.text = ""
            resultado.text = ""
        }
        backspace.setOnClickListener {
            val string = expressao.text.toString()
            if (string.isNotBlank()){
                expressao.text = string.substring(0,string.length-1)
            }
            resultado.text = ""
        }

        igual.setOnClickListener {
            try {
                val expressao = ExpressionBuilder(expressao.text.toString()).build()
                val result = expressao.evaluate()
                val longResult = result.toLong()

                if (result == longResult.toDouble())
                    resultado.text = longResult.toString()
                else
                    resultado.text = result.toString()


            }catch (e: Exception){

            }
        }

    }
    fun AcrescentarUmaExpressao( string: String, limpar_dados : Boolean){

        val expressao = findViewById<TextView>(R.id.expressao)
        val resultado = findViewById<TextView>(R.id.resultado)

        if (resultado.text.isNotEmpty()){
            expressao.text = ""
        }

        if(limpar_dados){
            resultado.text = ""
            expressao.append(string)
        } else{
            expressao.append(resultado.text)
            expressao.append(string)
            resultado.text = ""
        }

    }

}