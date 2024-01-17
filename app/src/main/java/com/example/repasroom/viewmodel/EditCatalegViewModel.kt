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
}
