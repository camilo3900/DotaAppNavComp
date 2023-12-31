package com.example.dotaapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dotaapp.R
import com.example.dotaapp.adapters.RegionsAdapter
import com.example.dotaapp.databinding.FragmentRegionsBinding


class RegionsFragment : Fragment() {

    private var _binding: FragmentRegionsBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerRegions : RecyclerView
    private lateinit var adapter: RegionsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentRegionsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerRegions = binding.rvRegiones
        adapter = RegionsAdapter(getRegions())
        recyclerRegions
            .layoutManager = LinearLayoutManager(requireContext(),
            LinearLayoutManager.HORIZONTAL, false)
        recyclerRegions.adapter = adapter

        adapter.clickItem = {
            val bundle = bundleOf(Pair("REGION", it))
            findNavController().navigate(R.id.action_regionsFragment_to_listTeamsFragment, bundle)
        }
    }

    private fun getRegions(): MutableList<String> {
        return mutableListOf("ASIA", "SUR AMERICA", "EUROPA", "NORT AMERICAN", "RUSIA", "SURESTE ASIA")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}