package com.example.myapplication.kotlin.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.myapplication.kotlin.database.UserDB
import com.example.myapplication.kotlin.database.entities.User
import com.example.myapplication.kotlin.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application): AndroidViewModel(application) {
     var userRepository: UserRepository
     var getAllInformation: LiveData<List<User>>
    init {
        val userDAO = UserDB.getAllInformationUser(application).useUserDAO()
        userRepository = UserRepository(userDAO)
        getAllInformation = userRepository.getAllInformationUser
    }

     fun insertNewUserInRecyclerView(user: User){
        viewModelScope.launch(Dispatchers.IO){
            userRepository.insertNewUserInRecyclerView(user)
        }
    }
    val getAllInformationUser:LiveData<List<User>> = userRepository.getAllInformationUser
    fun deleteAll(){
        viewModelScope.launch(Dispatchers.IO){
            userRepository.deleteAll()
        }
    }
}