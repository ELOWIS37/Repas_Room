package com.example.repasroom.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.repasroom.model.Moble

class SharedViewModel : ViewModel() {
    private val _selectedItem = MutableLiveData<Moble>()
    val selectedItem: LiveData<Moble> get() = _selectedItem

    //Seleccionar item DB
    fun setSelectedItem(item: Moble) {
        _selectedItem.value = item
    }
}