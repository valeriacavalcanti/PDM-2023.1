package com.example.chocolates

class Cesta {
    private var lista: MutableList<Chocolate>

    init{
        this.lista = mutableListOf()
    }

    fun add(chocolate: Chocolate){
        this.lista.add(chocolate)
    }

    fun get(index: Int): Chocolate{
        return this.lista.get(index)
    }

    fun get(): MutableList<Chocolate>{
        return this.lista
    }

    fun del(index: Int){
        this.lista.removeAt(index)
    }
}