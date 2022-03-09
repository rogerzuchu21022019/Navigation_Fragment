package com.example.myapplication.kotlin.database.entities

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "Table User")
data class User(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name ="STT")
    val stt:Int,
    @ColumnInfo(name = "Account")
    val account:String,
    @ColumnInfo(name = "Password")
    val password:String
):Parcelable

