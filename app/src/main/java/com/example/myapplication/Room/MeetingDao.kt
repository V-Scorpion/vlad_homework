package com.example.myapplication.Room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MeetingDao {

    @Insert
    fun insertMeet(meet: Meeting)

    @Query("SELECT * FROM meeting WHERE userId = :userId")
    fun findMeet(userId: String): List<Meeting>

    @Query("DELETE FROM meeting WHERE userId = :user")
    fun deleteUser(user: String)

    @Query("SELECT * FROM meeting")
    fun getAllMeeting(): LiveData<List<Meeting>>
}