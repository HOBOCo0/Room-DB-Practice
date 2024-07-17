package com.example.roomdatabasepractice


import androidx.room.Database
import androidx.room.RoomDatabase

/*
    we need to pass some information to aur database through this  annotations
     1 - as we may be going to have multiple  entities so it is an array(for now we have single entity of contact).
     2 - version is useful at the time of migration
    */
// we have to make our database class abstract
@Database(entities = [Contact::class], version = 0)
abstract class ContactDatabase: RoomDatabase() {

    // linking our DAO class to database
    // if we have multiple dao we can define functions like this
    abstract fun contactDao(): ContactDAO

    // so this is our ready database class, generally to use this we use singleton pattern concept
// because there must be only one instance of database in any application
}