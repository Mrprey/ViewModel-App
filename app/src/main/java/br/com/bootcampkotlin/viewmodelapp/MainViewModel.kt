package br.com.bootcampkotlin.viewmodelapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    var mContador = MutableLiveData<String>().apply {
        value = contador.toString()
    }

    private var contador = 0

    private fun setContador(){
        mContador.value = contador.toString()
    }

    private fun validaContador(){
        when {
            contador > 5 -> {contador = 0}
        }

        setContador()
    }

    fun addContador(){
        contador++
        validaContador()
    }
}