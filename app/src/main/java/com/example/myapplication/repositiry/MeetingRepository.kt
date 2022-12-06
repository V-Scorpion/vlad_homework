package com.example.myapplication.repositiry

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.Room.Meeting
import com.example.myapplication.Room.MeetingDao
import kotlinx.coroutines.*


class MeetingRepository (private  val meetDao: MeetingDao) {
    val allMeeting: LiveData<List<Meeting>> = meetDao.getAllMeeting()
    val searchResults = MutableLiveData<List<Meeting>>()
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    fun insertMeet(newproduct: Meeting) {
        coroutineScope.launch(Dispatchers.IO) {
            meetDao.insertMeet(newproduct)
        }
    }

    fun deleteMeet(userId: String) {
        coroutineScope.launch(Dispatchers.IO) {
            meetDao.deleteUser(userId)
        }
    }

    fun findMeet(userId: String) {
        coroutineScope.launch(Dispatchers.Main) {
            searchResults.value = asyncFind(userId).await()
        }
    }

    private fun asyncFind(userId: String): Deferred<List<Meeting>> =
        coroutineScope.async(Dispatchers.IO) {
            return@async meetDao.findMeet(userId)
        }
}