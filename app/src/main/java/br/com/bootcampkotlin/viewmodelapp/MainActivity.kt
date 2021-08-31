package br.com.bootcampkotlin.viewmodelapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    lateinit var txtNome: EditText
    lateinit var btDados: Button
    lateinit var btMostrar: Button

    lateinit var mViewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initDados()
        initClick()
    }

    private fun initClick() {
        btDados.setOnClickListener{
            mViewModel.addContador()
        }

        btMostrar.setOnClickListener{
            Toast.makeText(applicationContext, "Valor dos clicks: ${mViewModel.mContador.value}", Toast.LENGTH_SHORT).show()
        }
    }



    private fun initDados() {
        mViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        txtNome = findViewById(R.id.tp_contador)
        btDados = findViewById(R.id.bt_add)
        btMostrar = findViewById(R.id.bt_mostrar)

        mViewModel.mContador.observe(this, Observer {
            valor -> txtNome.setText(valor)
        })
    }


}