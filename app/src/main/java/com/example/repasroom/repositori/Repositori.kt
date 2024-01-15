package com.example.repasroom.repositori

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.repasroom.databases.CatalegDatabase
import com.example.repasroom.model.Moble
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Repositori {

    companion object {

        var catalegDatabase: CatalegDatabase? = null

        var moble: LiveData<List<Moble>>? = null


        fun initializeDB(context: Context): CatalegDatabase {
            return CatalegDatabase.getDatabase(context)
        }

        //INSERT moble
        fun insertMoble(context: Context, moble: Moble) {

            catalegDatabase = initializeDB(context)

            CoroutineScope(Dispatchers.IO).launch {
                catalegDatabase!!.catalegDao().addMoble(moble)
            }
        }

        //UPDATE moble
        fun editMoble(context: Context, moble: Moble) {

            catalegDatabase = initializeDB(context)

            CoroutineScope(Dispatchers.IO).launch {
                catalegDatabase!!.catalegDao().editMoble(moble)
            }
        }

        //DELETE moble
        fun deleteMoble(context: Context, moble: Moble) {

            catalegDatabase = initializeDB(context)

            CoroutineScope(Dispatchers.IO).launch {
                catalegDatabase!!.catalegDao().deleteMoble(moble)
            }
        }

        //SELECT* moble
        fun getMobles(context: Context): LiveData<List<Moble>>? {

            catalegDatabase = initializeDB(context)

            moble = catalegDatabase!!.catalegDao().getMobles()

            return moble
        }

        //SELECT ID moble
        fun getMobleById(context: Context, id: Int): LiveData<List<Moble>>? {

            catalegDatabase = initializeDB(context)

            return catalegDatabase!!.catalegDao().getMoblesById(id)
        }
    }
}