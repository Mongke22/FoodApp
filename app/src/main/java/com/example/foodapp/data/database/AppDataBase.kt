package com.example.foodapp.data.database

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.foodapp.data.database.dao.FoodInfoDao
import com.example.foodapp.data.database.model.FoodDbModel

@Database(
    entities = [FoodDbModel::class],
    version = 1, exportSchema = false
)

abstract class AppDataBase : RoomDatabase() {
    companion object {

        private var INSTANCE: AppDataBase? = null
        private const val DB_NAME = "food.db"
        private val LOCK = Any()

        fun getInstance(application: Application): AppDataBase {
            INSTANCE?.let {
                return it
            }
            synchronized(LOCK) {
                INSTANCE?.let { return it }
                val instance =
                    Room.databaseBuilder(
                        application,
                        AppDataBase::class.java,
                        DB_NAME
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                INSTANCE = instance
                return instance
            }
        }
    }

    abstract fun foodInfoDao(): FoodInfoDao
}