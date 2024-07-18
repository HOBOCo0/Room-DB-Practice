package com.example.roomdatabasepractice

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.room.Room
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

/*
here we have to create three things

1. Entities
2. Dao (data Access Object interface)
3.  declaration of Database

 */

class MainActivity : AppCompatActivity() {

    lateinit var database: ContactDatabase

    lateinit var text : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        text = findViewById(R.id.helloText)

        // this is not a good practice to create a database in any application
        // we can create multiple instances like this which is wrong we should use the concept of singleton pattern.
        // it will return the database object
       // database = Room.databaseBuilder(applicationContext,ContactDatabase::class.java,"contactDB").build()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        database = ContactDatabase.getDatabase(this)

        GlobalScope.launch {
            database.contactDao().insertContact(Contact(0,"john",9999))
        }

        database.contactDao().getContact().observe(this){

            text.setText("Hey there i am ok")
            Toast.makeText(this,"new data added", Toast.LENGTH_SHORT) }
    }
    }

    // onclick this function will
    fun getData(view: View) {

}