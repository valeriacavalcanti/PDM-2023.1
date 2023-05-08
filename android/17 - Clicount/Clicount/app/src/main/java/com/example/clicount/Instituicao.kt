package com.example.clicount

class Instituicao {
    var id: Int
    var nome: String
    var contador: Int

    constructor(nome: String){
        this.id = -1
        this.nome = nome
        this.contador = 0
    }

    constructor(id: Int, nome: String, contador: Int){
        this.id = id
        this.nome = nome
        this.contador = contador
    }

    override fun toString(): String {
        return "${id} - ${nome} - ${contador}"
    }
}