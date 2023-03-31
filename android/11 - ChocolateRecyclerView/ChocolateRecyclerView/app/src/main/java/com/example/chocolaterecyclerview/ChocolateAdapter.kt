package com.example.chocolaterecyclerview

import android.icu.text.Transliterator.Position
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.Collections

class ChocolateAdapter(val lista: MutableList<String>): RecyclerView.Adapter<ChocolateAdapter.MyHolder>() {
    var onItemClickRecyclerView: OnItemClickRecyclerView? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChocolateAdapter.MyHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler, parent, false)
        return MyHolder(view)
    }

    override fun onBindViewHolder(holder: ChocolateAdapter.MyHolder, position: Int) {
        val chocolate = this.lista.get(position)
        holder.tvNome.text = chocolate
    }

    override fun getItemCount(): Int {
        return this.lista.size
    }

    fun add(nome: String){
        this.lista.add(nome)
        this.notifyDataSetChanged()
    }

    fun del(index: Int){
        this.lista.removeAt(index)
        this.notifyItemRemoved(index)
        this.notifyItemRangeChanged(index, this.lista.size)
    }

    fun mov(from: Int, to: Int){
        Collections.swap(this.lista, from, to)
        this.notifyItemMoved(from, to)
    }

    inner class MyHolder(item: View): RecyclerView.ViewHolder(item){
        var tvNome: TextView

        init {
            this.tvNome = item.findViewById(R.id.tvItemNome)
            item.setOnClickListener({
                this@ChocolateAdapter.onItemClickRecyclerView?.onItemClick(this.adapterPosition)
            })
        }
    }
}