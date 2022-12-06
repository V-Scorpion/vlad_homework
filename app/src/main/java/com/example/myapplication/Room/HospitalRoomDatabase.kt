package com.example.myapplication.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [(User::class),(Meeting::class),(MedicalCard::class)], version = 1)
abstract class HospitalRoomDatabase: RoomDatabase() {
 
abstract fun UserDao(): UserDao
abstract fun MeetingDao(): MeetingDao
abstract fun MedicalCard(): MedicalCardDao

    companion object {
 
        private var INSTANCE: HospitalRoomDatabase? = null
 
        fun getInstance(context: Context): HospitalRoomDatabase {
            synchronized(this) {
                var instance = INSTANCE
 
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        HospitalRoomDatabase::class.java,
                        "user_database"
                    ).fallbackToDestructiveMigration()
                        .build()
 
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}