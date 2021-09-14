package br.com.unipac.conversorcombustivel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val vlrGasolinaEdt = findViewById<EditText>(R.id.vlrGosolinaEdt)
        val vlrEtanolEdt = findViewById<EditText>(R.id.vlrEtanolEdt)
        val calcularBtn = findViewById<Button>(R.id.calcularBtn)
        val resultadoTv = findViewById<TextView>(R.id.resultadoTv)

        calcularBtn.setOnClickListener {

            val vlrGasolinaEdt = vlrGasolinaEdt.text.toString().trim()
            val vlrEtanolEdt = vlrEtanolEdt.text.toString().trim()

            if (vlrGasolinaEdt.isNotEmpty() && vlrEtanolEdt.isNotEmpty()) {

                val valorGasolina: Double = vlrGasolinaEdt.toDouble()
                val valorEtanol: Double = vlrEtanolEdt.toDouble()

                var valorMedia = valorEtanol / valorGasolina
                if (valorMedia > 0.7) {
                    resultadoTv.text = "Nesse caso é melhor colocar Gasolina"
                } else {
                    resultadoTv.text = "Nesse caso é melhor colocar Etanol"
                }

            } else {
                Toast.makeText(
                    this,
                    "É necessário digitar os valores dos combustíveis",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}