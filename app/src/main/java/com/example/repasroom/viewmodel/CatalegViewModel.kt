package com.example.repasroom.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.repasroom.model.Moble
import com.example.repasroom.repositori.Repositori

class CatalegViewModel: ViewModel() {
    //select mobles
    fun obtenirMobles(context: Context) : LiveData<List<Moble>>? {
        return Repositori.getMobles(context)
    }
}