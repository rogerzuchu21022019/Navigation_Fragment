package com.example.myapplication.kotlin.repository

import androidx.lifecycle.LiveData
import androidx.room.Query
import com.example.myapplication.kotlin.database.DAO.UserDAO
import com.example.myapplication.kotlin.database.UserDB
import com.example.myapplication.kotlin.database.entities.User

 class UserRepository(private val useUserDAO: UserDAO) {
    suspend fun insertNewUserInRecyclerView(user: User){
        useUserDAO.insertNewUserInRecyclerView(user)
    }
    val getAllInformationUser:LiveData<List<User>> = useUserDAO.getAllInformationUser()
     suspend fun deleteAll(){
        useUserDAO.deleteAll()
     }
}