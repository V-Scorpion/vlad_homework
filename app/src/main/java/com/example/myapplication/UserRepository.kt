package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.Room.User
import com.example.myapplication.Room.UserDao
import kotlinx.coroutines.*

class UserRepository (private  val userDao: UserDao) {
    val allProducts: LiveData<List<User>> = userDao.getAllUser()
    val searchResults = MutableLiveData<List<User>>()
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    fun insertUser(newproduct: User) {
        coroutineScope.launch(Dispatchers.IO) {
            userDao.insertUser(newproduct)
        }
    }

    fun deleteUser(login: String) {
        coroutineScope.launch(Dispatchers.IO) {
            userDao.deleteUser(login)
        }
    }

    fun findUser(login: String, password: String) {
        coroutineScope.launch(Dispatchers.Main) {
            searchResults.value = asyncFind(login, password).await()
        }
    }

    private fun asyncFind(login: String, password: String): Deferred<List<User>?> =
        coroutineScope.async(Dispatchers.IO) {
            return@async userDao.findUser(login, password)
        }
}