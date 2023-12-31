package com.example.dotaapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dotaapp.R
import com.example.dotaapp.adapters.TeamsAdapter
import com.example.dotaapp.data.Teams
import com.example.dotaapp.databinding.FragmentListTeamsBinding



class ListTeamsFragment : Fragment() {

    private var _binding: FragmentListTeamsBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter1: TeamsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentListTeamsBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val region: String = arguments?.getString("REGION")?: ""
        binding.tvTeamList.text = "TEAMS: $region"
        adapter1 = TeamsAdapter(Teams.getTeamsByRegion(region).toMutableList(), requireContext())
        adapter1.notifyDataSetChanged()
        binding.rvTeams.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = adapter1
        }
        (adapter1 as? TeamsAdapter)?.clickItem = {
            val bundle = bundleOf(Pair("TEAM", it))
            Navigation.findNavController(binding.root).navigate(R.id.action_listTeamsFragment_to_teamDetailFragment, bundle)
        }
        binding.btnBackRegion.setOnClickListener {
            findNavController().popBackStack()//Return last fragment
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}