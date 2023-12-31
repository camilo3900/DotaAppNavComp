package com.example.dotaapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dotaapp.R
import com.example.dotaapp.databinding.RegionItemListBinding

class RegionsAdapter(private val regiones: MutableList<String>):
    RecyclerView.Adapter<RegionsAdapter.ViewHolder>() {
    lateinit var clickItem: (String)-> Unit

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        private val binding: RegionItemListBinding = RegionItemListBinding.bind(view)
        fun bind(region:String){
            binding.tvRegion.text = region
            binding.btnGo.setOnClickListener {
                clickItem(region)
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val layout = LayoutInflater.from(viewGroup.context).inflate(R.layout.region_item_list, viewGroup, false)

        return ViewHolder(layout)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val region = regiones[position]
        viewHolder.bind(region)
    }

    override fun getItemCount(): Int = regiones.size

}