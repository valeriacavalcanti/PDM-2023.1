package com.example.chocolates

class Chocolate (var descricao: String, var quantidade: Int): java.io.Serializable{
    override fun toString(): String {
        return "${descricao} - ${quantidade}"
    }
}