package com.novelitech.roommigrationguidekotlin.database

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RenameColumn
import androidx.room.RoomDatabase
import androidx.room.migration.AutoMigrationSpec
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.novelitech.roommigrationguidekotlin.daos.SchoolDao
import com.novelitech.roommigrationguidekotlin.daos.UserDao
import com.novelitech.roommigrationguidekotlin.entities.SchoolEntity
import com.novelitech.roommigrationguidekotlin.entities.UserEntity

@Database(
    entities = [
        UserEntity::class,
        SchoolEntity::class,
    ],
    version = 4,
    autoMigrations = [
        AutoMigration(from = 1, to = 2), // from and to are the versions from database (previous and current one)
        AutoMigration(from = 2, to = 3, spec = UserDatabase.Migration2To3::class),
    ]
)
abstract class UserDatabase: RoomDatabase() {

    abstract val userDao: UserDao

    abstract val schoolDao: SchoolDao

    @RenameColumn(tableName = "users", fromColumnName = "createdOn", toColumnName = "createdAt")
    class Migration2To3: AutoMigrationSpec

    companion object {
        val migration3To4 = object : Migration(startVersion = 3, endVersion = 4) {

            override fun migrate(db: SupportSQLiteDatabase) {

                db.execSQL("CREATE TABLE IF NOT EXISTS schools (name CHAR NOT NULL PRIMARY KEY)")
            }
        }
    }


}