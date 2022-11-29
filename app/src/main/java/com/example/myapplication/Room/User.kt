package com.example.myapplication.Room

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
class User {
 
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "userId")
    var id: Int = 0
    @ColumnInfo(name = "login")
    var login: String = ""
    @ColumnInfo(name = "password")
    var password: String = ""
    @ColumnInfo(name = "access_rule")
    var access_rule: String = ""

 
    constructor() {}
 
    constructor(login: String,password: String,access_rule: String) {
        this.id = id
        this.login = login
        this.password = password
        this.access_rule = access_rule
    }
}