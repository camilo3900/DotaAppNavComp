package com.example.dotaapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.example.dotaapp.R
import com.example.dotaapp.data.Teams.formato
import com.example.dotaapp.databinding.FragmentTeamDetailBinding
import com.example.dotaapp.model.Team


class TeamDetailFragment : Fragment() {
    private var _binding: FragmentTeamDetailBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentTeamDetailBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val team = arguments?.getParcelable<Team>("TEAM")
        setDetailData(team)
        binding.btnBack.setOnClickListener {
            Navigation.findNavController(binding.root).popBackStack()
        }
    }

    private fun setDetailData(team: Team?) {
        binding.tvDetailName.text = team?.name ?: "Nombre"
        binding.tvDetailCountry.text = team?.country ?: "Pais"
        binding.tvDetailRegion.text = team?.region ?: "Region"
        binding.tvDetailProfit.text = team?.profit ?: "$0.0"
        binding.tvDetailStartDate.text = (formato.format(team?.startDate) ?:
        formato.format("2020-02-02")).toString()
        binding.tvDetailEndDate.text = (formato.format(team?.endDate) ?:
        formato.format("2020-02-02")).toString()
        Glide.with(requireContext()).load(team?.logo).placeholder(R.drawable.placeholder_logo).into(binding.imgDetailLogo)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}