package com.example.valyutaapiconnection.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.example.valyutaapiconnection.databinding.ItemRvBinding
import com.example.valyutaapiconnection.models.Valyuta
import kotlinx.coroutines.withContext

class RvAdapter(val list: ArrayList<Valyuta>):RecyclerView.Adapter<RvAdapter.Valyutalar>(){
    inner class Valyutalar(val itemRvBinding: ItemRvBinding):RecyclerView.ViewHolder(itemRvBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Valyutalar {
        val itemRvBinding=ItemRvBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return Valyutalar(itemRvBinding)
    }

    override fun getItemCount(): Int =list.size

    override fun onBindViewHolder(holder: Valyutalar, position: Int) {
        holder.itemRvBinding.name.text=list[position].CcyNm_UZ
        holder.itemRvBinding.age.text=list[position].Ccy
    }

}