package com.example.repasroom.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.repasroom.R
import com.example.repasroom.databinding.FragmentEditCatalegBinding
import com.example.repasroom.databinding.FragmentInsertCatalegBinding
import com.example.repasroom.viewmodel.CatalegViewModel
import com.example.repasroom.viewmodel.EditCatalegViewModel
import com.example.repasroom.viewmodel.SharedViewModel

class EditCatalegFragment : Fragment() {

    private lateinit var binding: FragmentEditCatalegBinding
    private lateinit var sharedViewModel: SharedViewModel
    private lateinit var editViewModel: EditCatalegViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_edit_cataleg, container, false
        )

        editViewModel = ViewModelProvider(this).get(EditCatalegViewModel::class.java)
        sharedViewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        sharedViewModel.selectedItem.observe(viewLifecycleOwner, Observer { selectedItem ->
            Log.d("Observer", "Observer ejecutado. Valor actual de selectedItem: $selectedItem")
            binding.nomEditTextEdit.setText(selectedItem?.nom)
            binding.preuEditNomEdit.setText((selectedItem?.preu.toString()))
        })

        binding.deleteButton.setOnClickListener {
            val selectedItem = sharedViewModel.selectedItem.value
            val id = selectedItem?.Id
            if (id != null) {
                editViewModel.deleteMoble(requireContext(), id)
            }
            Navigation.findNavController(it).navigate(R.id.action_editCatalegFragment_to_catalegFragment)
        }
        return binding.root
    }
}
