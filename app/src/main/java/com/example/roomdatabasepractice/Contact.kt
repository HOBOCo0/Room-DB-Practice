package com.example.roomdatabasepractice

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "contact")
data class Contact(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name:String,
    val phone: Int,
    val isActive: Int
)