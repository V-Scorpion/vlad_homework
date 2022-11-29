package com.example.myapplication.Room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {

    @Insert
    fun insertUser(user: User)

    @Query("SELECT * FROM users WHERE login = :login and password =:password")
    fun findUser(login: String, password: String): List<User>

    @Query("DELETE FROM users WHERE login = :login")
    fun deleteUser(login: String)

    @Query("SELECT * FROM users")
    fun getAllUser(): LiveData<List<User>>
}