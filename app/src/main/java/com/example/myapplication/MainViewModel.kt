package com.example.myapplication

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.Room.HospitalRoomDatabase
import com.example.myapplication.Room.Meeting
import com.example.myapplication.Room.User
import com.example.myapplication.repositiry.MeetingRepository
import com.example.myapplication.repositiry.UserRepository

class MainViewModel(application: Application) : ViewModel() {
 
    val allUsers: LiveData<List<User>>
    private val repository_user: UserRepository
    val searchResults: MutableLiveData<List<User>>

    val allMeeting: LiveData<List<Meeting>>
    val allGuestMeeting: LiveData<List<Meeting>>
    private val repository_meeting: MeetingRepository



    init {
    val HospitalDb = HospitalRoomDatabase.getInstance(application)
        val userDao = HospitalDb.UserDao()
        val meetingDao = HospitalDb.MeetingDao()

        repository_user = UserRepository(userDao)

        allUsers = repository_user.allProducts
        searchResults = repository_user.searchResults

        repository_meeting = MeetingRepository(meetingDao)

        allMeeting = repository_meeting.allMeeting
        allGuestMeeting = repository_meeting.searchResults
    }

    fun insertUser(user: User) {
        repository_user.insertUser(user)
    }

    fun findUser(login: String,password:String) {
        repository_user.findUser(login,password)
    }

    fun deleteUser(name: String) {
        repository_user.deleteUser(name)
    }

    fun insertMeet(meeting: Meeting){
        repository_meeting.insertMeet(meeting)
    }

    fun findMeet(user_id: String) {
        repository_meeting.findMeet(user_id)
    }

    fun deleteMeet(name: String) {
        repository_meeting.deleteMeet(name)
    }
}