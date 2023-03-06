package com.example.sorteio

class Cadastro {
    var lista: MutableList<String>

    init {
        this.lista = mutableListOf()
    }

    fun add(texto: String){
        this.lista.add(texto)
    }

    fun sorteio(): String?{
        if (lista.size > 0)
            return this.lista.random()
        else return null
    }
}