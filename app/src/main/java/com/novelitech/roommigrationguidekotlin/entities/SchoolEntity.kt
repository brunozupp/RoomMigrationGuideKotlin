package com.novelitech.roommigrationguidekotlin.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "schools")
data class SchoolEntity(

    @PrimaryKey(autoGenerate = false)
    val name: String,
)
