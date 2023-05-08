package com.example.clicount

import android.content.ContentValues
import android.content.Context
import android.util.Log

class InstituicaoDAO {
    var banco: BancoHelper

    constructor(context: Context){
        this.banco = BancoHelper(context)
    }

    fun add(instituicao: Instituicao){
        val cv = ContentValues().apply {
            put("nome", instituicao.nome)
            put("contador", instituicao.contador)
        }
        this.banco.writableDatabase.insert("instituicao", null, cv)
    }

    fun count(): Int{
        val colunas = arrayOf("id")
        val c = this.banco.readableDatabase.query("instituicao", colunas, null, null, null, null, "contador")
        return c.count
    }

    fun get(): MutableList<Instituicao>{
        val lista = mutableListOf<Instituicao>()
        val colunas = arrayOf("id", "nome", "contador")
        val c = this.banco.readableDatabase.query("instituicao", colunas, null, null, null, null, "contador desc")
        c.moveToFirst()
//        Log.i("APPBANCO", lista.toString())
        for (i in 1..c.count){
            val id = c.getInt(0)
            val nome = c.getString(1)
            val contador = c.getInt(2)
            lista.add(Instituicao(id, nome, contador))
            c.moveToNext()
        }
//        Log.i("APPBANCO", lista.toString())
        return lista
    }

    fun get(id: Int): Instituicao?{
        val where = "id = ?"
        val pWhere = arrayOf(id.toString())
        val colunas = arrayOf("id", "nome", "contador")
        val c = this.banco.readableDatabase.query("instituicao", colunas, where, pWhere, null, null, "contador")
        c.moveToFirst()
        if (c.count == 1){
            val id = c.getInt(0)
            val nome = c.getString(1)
            val contador = c.getInt(2)
            return Instituicao(id, nome, contador)
        }
        return null
    }

    fun update(instituicao: Instituicao){
        val where = "id = ?"
        val pWhere = arrayOf(instituicao.id.toString())
        val cv = ContentValues().apply {
            put("contador", instituicao.contador + 1)
        }
        this.banco.writableDatabase.update("instituicao", cv, where, pWhere)
    }

    fun delete(id: Int){
        val where = "id = ?"
        val pWhere = arrayOf(id.toString())
        this.banco.writableDatabase.delete("instituicao", where, pWhere)
    }

    fun delete(instituicao: Instituicao){
        val where = "id = ?"
        val pWhere = arrayOf(instituicao.id.toString())
        this.banco.writableDatabase.delete("instituicao", where, pWhere)
    }
}