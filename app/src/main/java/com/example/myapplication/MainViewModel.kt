package com.example.myapplication

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.Room.HospitalRoomDatabase
import com.example.myapplication.Room.User

class MainViewModel(application: Application) : ViewModel() {
 
    val allUsers: LiveData<List<User>>
    private val repository: UserRepository
    val searchResults: MutableLiveData<List<User>>
 
    init {
    val productDb = HospitalRoomDatabase.getInstance(application)
        val productDao = productDb.userDao()
        repository = UserRepository(productDao)

        allUsers = repository.allProducts
        searchResults = repository.searchResults
    }

    fun insertUser(product: User) {
        repository.insertUser(product)
    }

    fun findUser(login: String,password:String) {
        repository.findUser(login,password)
    }

    fun deleteUser(name: String) {
        repository.deleteUser(name)
    }
}