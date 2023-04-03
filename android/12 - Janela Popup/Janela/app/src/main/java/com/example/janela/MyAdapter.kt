package com.example.janela

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(val lista: MutableList<String>): RecyclerView.Adapter<MyAdapter.MyHolder>() {
    var onItemClickRecyclerView: OnItemClickRecyclerView? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return MyHolder(view)
    }

    override fun onBindViewHolder(holder: MyAdapter.MyHolder, position: Int) {
        val nome = this.lista.get(position)
        holder.tvNome.text = nome
    }

    override fun getItemCount(): Int {
        return this.lista.size
    }

    fun add(nome: String){
        this.lista.add(nome)
        this.notifyItemInserted(this.lista.size)
    }

    inner class MyHolder (itemView: View): RecyclerView.ViewHolder(itemView){
        var tvNome: TextView

        init {
            this.tvNome = itemView.findViewById(R.id.tvItemNome)

            itemView.setOnClickListener({
                this@MyAdapter.onItemClickRecyclerView?.onItemClick(this.adapterPosition)
            })
        }
    }
}