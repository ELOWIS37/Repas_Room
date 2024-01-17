package com.example.repasroom.databases

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.repasroom.model.Moble

@Dao
interface CatalegDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addMoble(moble: Moble)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    fun editMoble(moble: Moble)

    @Query("DELETE FROM Moble WHERE Id = :id")
    fun deleteMoble(id: Int)

    @Query("SELECT * FROM Moble ORDER BY nom DESC")
    fun getMobles(): LiveData<List<Moble>>

    @Query("SELECT * FROM Moble  where id =:id")
    fun getMoblesById(id:Int): LiveData<List<Moble>>
}