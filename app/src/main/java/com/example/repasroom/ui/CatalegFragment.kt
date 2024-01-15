package com.example.repasroom.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.repasroom.R
import com.example.repasroom.adapter.MobleAdapter
import com.example.repasroom.databinding.FragmentCatalegBinding
import com.example.repasroom.viewmodel.CatalegViewModel

class CatalegFragment : Fragment() {

    private lateinit var binding: FragmentCatalegBinding
    private lateinit var catalegViewModel: CatalegViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_cataleg, container, false
        )
        catalegViewModel = ViewModelProvider(this).get(CatalegViewModel::class.java)

        binding.plusButton.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_catalegFragment_to_insertCatalegFragment)
        }

        viewManager = LinearLayoutManager(context)
        recyclerView = binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
        }

        catalegViewModel.obtenirMobles(requireContext())?.observe(viewLifecycleOwner, Observer { moblesLlistat ->
            viewAdapter = MobleAdapter(moblesLlistat)
            recyclerView.adapter = viewAdapter
        })

        return binding.root
    }
}
