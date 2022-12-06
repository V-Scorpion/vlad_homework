package com.example.myapplication.Room

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "medicalcard")
class MedicalCard {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "medicalcardId")
    var id: Int = 0
    @ColumnInfo(name = "user_id")
    var user_id: String = ""
    @ColumnInfo(name = "data")
    var data: String = ""


    constructor() {}

    constructor(id: Int, user_id: String, data: String) {
        this.id = id
        this.user_id = user_id
        this.data = data
    }
}