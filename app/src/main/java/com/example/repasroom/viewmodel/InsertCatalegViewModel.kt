package com.example.repasroom.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.repasroom.model.Moble
import com.example.repasroom.repositori.Repositori

class InsertCatalegViewModel: ViewModel() {

    //insert moble
    fun newMoble(context: Context, nom:String, preu:Int) {

        var moble = Moble(nom, preu)
        Repositori.insertMoble(context,moble)
    }

}