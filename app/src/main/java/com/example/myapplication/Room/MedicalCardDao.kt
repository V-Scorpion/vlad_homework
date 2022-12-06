package com.example.myapplication.Room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


@Dao
interface MedicalCardDao {

    @Insert
    fun insertMedicalCard(meet: MedicalCard)

    @Update
    fun updateMedicalCard(medicalCard: MedicalCard)

    @Query("SELECT * FROM medicalcard WHERE user_id = :user_id")
    fun findMedicalCard(user_id: String): List<MedicalCard>

    @Query("DELETE FROM medicalcard WHERE medicalcardId = :medicalcard")
    fun deleteMedicalCard(medicalcard: String)

    @Query("SELECT * FROM medicalcard")
    fun getAllMedicalCard(): LiveData<List<MedicalCard>>
}