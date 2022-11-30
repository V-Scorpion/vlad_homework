package com.example.myapplication.Room

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "meeting")
class Meeting {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "meetingId")
    var id: Int = 0
    @ColumnInfo(name = "userId")
    var user_id: String = ""
    @ColumnInfo(name = "date")
    var date: String = ""
    @ColumnInfo(name = "time")
    var time: String = ""


    constructor() {}

    constructor(user_id: String,date: String,time: String) {
        this.id = id
        this.user_id = user_id
        this.date = date
        this.time = time
    }
}