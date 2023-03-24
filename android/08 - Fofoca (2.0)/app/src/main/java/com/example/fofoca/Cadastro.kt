package com.example.fofoca

class Cadastro {
    private var lista: MutableList<Fofoca>

    init {
        this.lista = mutableListOf()
    }

    fun add(fofoca: Fofoca){
        this.lista.add(fofoca)
    }

    fun size(): Int{
        return this.lista.size
    }

    fun get(): Fofoca{
        return this.lista.random()
    }
}