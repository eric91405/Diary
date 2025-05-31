package com.example.diary

import androidx.activity.SystemBarStyle.Companion.auto
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "diary")
data class Diary(
    @PrimaryKey(autoGenerate = true) val id: Int =0,
    val title: String,
    val content: String,
    val date: String
)
