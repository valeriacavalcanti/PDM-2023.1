package com.example.chocolatebaseadapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class ChocolateAdapter(var contexto: Context, val lista: MutableList<String>): BaseAdapter() {
    override fun getCount(): Int {
        return this.lista.size
    }

    override fun getItem(position: Int): Any {
        return this.lista.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    fun add(nome: String){
        this.lista.add(nome)
        notifyDataSetChanged()
    }

    fun del(index: Int){
        this.lista.removeAt(index)
        notifyDataSetChanged()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = if (convertView == null){
            LayoutInflater.from(this.contexto).inflate(R.layout.item_list, parent, false)
        }else{
            convertView
        }

        val tvNome = view.findViewById<TextView>(R.id.tvItemNome)
        val nome = this.lista.get(position)
        tvNome.text = nome

        return view
    }

}