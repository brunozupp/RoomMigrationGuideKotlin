package com.novelitech.roommigrationguidekotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.novelitech.roommigrationguidekotlin.database.UserDatabase
import com.novelitech.roommigrationguidekotlin.entities.SchoolEntity
import com.novelitech.roommigrationguidekotlin.ui.theme.RoomMigrationGuideKotlinTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db = Room.databaseBuilder(
            applicationContext,
            UserDatabase::class.java,
            "roommigrationguide.db"
        )
            .addMigrations(
                UserDatabase.migration3To4
            )
            .build()

//        (1..10).forEach {
//            lifecycleScope.launch {
//                db.schoolDao.insert(
//                    SchoolEntity(
//                        name = "School$it",
//                    )
//                )
//            }
//        }

        lifecycleScope.launch {
            db.schoolDao.getAll().forEach(::println)
        }

//        (1..10).forEach {
//            lifecycleScope.launch {
//                db.userDao.insert(
//                    UserEntity(
//                        email = "test@test$it.com",
//                        username = "test$it"
//                    )
//                )
//            }
//        }

//        lifecycleScope.launch {
//            db.userDao.getAll().forEach(::println)
//        }

        setContent {
            RoomMigrationGuideKotlinTheme {
                Box(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text(text = "Ola")
                }
            }
        }
    }
}
