package com.example.myapplication.kotlin.database.DAO

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.myapplication.kotlin.database.entities.User

@Dao
interface UserDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNewUserInRecyclerView(user: User)
    @Query("select * from `Table User`")
    fun getAllInformationUser():LiveData<List<User>>
    @Query("delete from `TABLE USER`")
    suspend fun deleteAll()
}