package com.novelitech.roommigrationguidekotlin.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.novelitech.roommigrationguidekotlin.entities.SchoolEntity

@Dao
interface SchoolDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(school: SchoolEntity)

    @Query("SELECT * FROM schools")
    suspend fun getAll() : List<SchoolEntity>
}