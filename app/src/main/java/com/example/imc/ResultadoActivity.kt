package com.example.imc

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultadoActivity : AppCompatActivity() {

    private lateinit var titleDensidadeCorporal: TextView
    private lateinit var textViewHeaderDensidadeCorporal: TextView
    private lateinit var textViewResultadoIMC: TextView
    private lateinit var textViewResultadoPeso: TextView
    private lateinit var textViewResultadoAltura: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado2)

        titleDensidadeCorporal = findViewById(R.id.titleDensidadeCorporal)
        textViewHeaderDensidadeCorporal = findViewById(R.id.textViewHeaderDensidadeCorporal)
        textViewResultadoIMC = findViewById(R.id.textViewResultadoIMC)
        textViewResultadoPeso = findViewById(R.id.textViewResultadoPeso)
        textViewResultadoAltura = findViewById(R.id.textViewResultadoAltura)

        val imc = intent.getParcelableExtra<IMC>("value")
        val classificacao = imc?.calcular()
        val imcArredondado = String.format("%.2f", imc?.imc)

        titleDensidadeCorporal.text = imc?.nome.toString()
        textViewHeaderDensidadeCorporal.text = classificacao
        textViewResultadoIMC.text = "${getString(R.string.labelResultadoIMC)} $imcArredondado"
        textViewResultadoPeso.text = "${getString(R.string.labelResultadoPeso)} ${imc?.peso}"
        textViewResultadoAltura.text = "${getString(R.string.labelResultadoAltura)} ${imc?.altura}"
    }
}