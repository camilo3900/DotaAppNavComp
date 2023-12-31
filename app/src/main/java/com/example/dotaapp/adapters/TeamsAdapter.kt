package com.example.dotaapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dotaapp.R
import com.example.dotaapp.databinding.TeamItemListBinding
import com.example.dotaapp.model.Team

class TeamsAdapter(private var team: MutableList<Team>, val context: Context):
    RecyclerView.Adapter<TeamsAdapter.ViewHolder>() {
    lateinit var clickItem: (team:Team) -> Unit

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(equipo: Team){
            val binding: TeamItemListBinding = TeamItemListBinding.bind(itemView)
            binding.tvNombreTeam.text = equipo.name
            binding.tvPaisTeam.text = equipo.country
            Glide.with(context)
                .load(equipo.logo)
                .placeholder(R.drawable.placeholder_logo2)
                .into(binding.imgTeam)

            itemView.setOnClickListener {
                clickItem(equipo)
            }
        }


    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(viewGroup.context)
            .inflate(R.layout.team_item_list, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val element = team[position]
        viewHolder.bind(element)
    }

    override fun getItemCount(): Int = team.size
}
