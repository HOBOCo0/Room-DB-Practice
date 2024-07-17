package com.example.roomdatabasepractice

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

/*
  -> We declare all the methods to access the data here. all the implementation
     of these methods are provided by room.

  -> We execute these functions on the background thread because Android don't
     want to execute long running tasks on main thread or ui thread so we make these functions
     as suspend as we want coroutine to run these functions.

  -> We can make threads manually or we can use executors to run these functions.
 */
@Dao
interface ContactDAO {
    @Insert
    suspend fun insertContact(contact:Contact)
    @Update
    suspend fun updateContact(contact:Contact)
    @Delete
    suspend fun deleteContact(contact:Contact)

    // for query we will use live data, Behind the scene Rood checks if its return type is LiveData
    // then by default it is executed on background thread. here we don't have to manually declare
    // it to be a suspend function
    @Query("SELECT * FROM contact")
    fun getContact(): LiveData<List<Contact>>
}