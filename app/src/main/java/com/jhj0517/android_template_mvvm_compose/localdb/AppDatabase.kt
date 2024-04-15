package com.jhj0517.android_template_mvvm_compose.localdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import com.jhj0517.android_template_mvvm_compose.constants.AppConstants
import com.jhj0517.android_template_mvvm_compose.models.localdb.ExampleData


@Database(entities = [ExampleData::class], exportSchema = false, version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun dataDao(): DataDao

    companion object{
        @Volatile private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDB(context).also { instance = it }
            }
        }

        private fun buildDB(context: Context): AppDatabase {
            return databaseBuilder(
                context,
                AppDatabase::class.java,
                AppConstants.DB_NAME
            ).build()
        }
    }

}