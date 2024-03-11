package com.novelitech.roommigrationguidekotlin.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey(autoGenerate = false)
    val email: String,

    val username: String,

    @ColumnInfo(name = "createdOn", defaultValue = "0") // Even if I have "System.currentTimeMillis()" it will set 0 as default value
    val createdAt: Long = System.currentTimeMillis(),
)
