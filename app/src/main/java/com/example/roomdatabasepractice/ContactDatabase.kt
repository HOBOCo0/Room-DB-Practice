package com.example.roomdatabasepractice


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/*
    we need to pass some information to aur database through this  annotations
     1 - as we may be going to have multiple  entities so it is an array(for now we have single entity of contact).
     2 - version is useful at the time of migration
    */
// we have to make our database class abstract
@Database(entities = [Contact::class], version = 1)
abstract class ContactDatabase : RoomDatabase() {

    // linking our DAO class to database
    // if we have multiple dao we can define functions like this
    abstract fun contactDao(): ContactDAO

    // so this is our ready database class, generally to use this we use singleton pattern concept
// because there must be only one instance of database in any application

    // implementation of singleton patterns

    companion object {
        // private field to hold database instance

        //the moment INSTANCE gets updated Volatile makes all the threads know that
        // the value of Instance is updated and this is the value
        @Volatile
        private var INSTANCE: ContactDatabase? = null

        fun getDatabase(context: Context): ContactDatabase {
            if (INSTANCE == null) {
                // there might be chance that two diff threads will create the instance at a
                // time so to sync the instance we use synchronized block.It will help creating only single instance
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        ContactDatabase::class.java,
                        "contactDB"
                    ).build()
                }
            }
            // non nullable return type
            return INSTANCE!!
        }
    }
}