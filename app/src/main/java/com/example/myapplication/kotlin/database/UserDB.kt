package com.example.myapplication.kotlin.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.kotlin.database.DAO.UserDAO
import com.example.myapplication.kotlin.database.entities.User

@Database(entities = [User::class], exportSchema = false, version = 1)
abstract class UserDB : RoomDatabase() {
    abstract fun useUserDAO(): UserDAO

    companion object {
        val DB_NAME: String = "UserDatabase"

        @Volatile
        var INSTANCE: UserDB? = null
        fun getAllInformationUser(context: Context): UserDB {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext, UserDB::class.java, DB_NAME
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}