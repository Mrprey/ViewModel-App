package br.com.bootcampkotlin.viewmodelapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var txtNome: EditText
    lateinit var btDados: Button
    lateinit var btMostrar: Button
    protected var contador = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initDados()
        initContador()
        initClick()
    }

    private fun initClick() {
        btDados.setOnClickListener{
            contador ++
            initContador()
        }

        btMostrar.setOnClickListener{
            Toast.makeText(this, "Valor dos clicks: ${contador.toString()}", Toast.LENGTH_SHORT).show()
        }
    }

    private fun initContador() {
        when {
            contador > 5 -> {contador = 0}
        }
        txtNome.setText(contador.toString())
    }

    private fun initDados() {
        txtNome = findViewById(R.id.tp_contador)
        btDados = findViewById(R.id.bt_add)
        btMostrar = findViewById(R.id.bt_mostrar)
    }


}