package com.example.repasroom.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.repasroom.model.Moble
import com.example.repasroom.repositori.Repositori

class EditCatalegViewModel: ViewModel() {
    //delete moble
    fun deleteMoble(context: Context, id: Int) {
        Repositori.deleteMoble(context, id)
    }

    //update moble
    fun editMoble(context: Context, id: Int, nom:String, preu: Int) {
        Repositori.editMoble(context, id, nom, preu)
    }
}
