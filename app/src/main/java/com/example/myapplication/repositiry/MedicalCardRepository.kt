package com.example.myapplication.repositiry

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.Room.MedicalCard
import com.example.myapplication.Room.MedicalCardDao
import com.example.myapplication.Room.Meeting
import com.example.myapplication.Room.MeetingDao
import kotlinx.coroutines.*


class MedicalCardRepository (private  val medicalCardDao: MedicalCardDao) {
    val allMedicalCard: LiveData<List<MedicalCard>> = medicalCardDao.getAllMedicalCard()
    val searchResults = MutableLiveData<List<MedicalCard>>()
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    fun insertMedicalCard(newproduct: MedicalCard) {
        coroutineScope.launch(Dispatchers.IO) {
            medicalCardDao.insertMedicalCard(newproduct)
        }
    }

    fun deleteMedicalCard(userId: String) {
        coroutineScope.launch(Dispatchers.IO) {
            medicalCardDao.deleteMedicalCard(userId)
        }
    }

    fun findMedicalCard(userId: String) {
        coroutineScope.launch(Dispatchers.Main) {
            searchResults.value = asyncFind(userId).await()
        }
    }

    private fun asyncFind(userId: String): Deferred<List<MedicalCard>> =
        coroutineScope.async(Dispatchers.IO) {
            return@async medicalCardDao.findMedicalCard(userId)
        }
}