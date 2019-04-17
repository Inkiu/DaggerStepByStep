package com.example.daggerstepbystep.data

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.Resources
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.daggerstepbystep.di.ApplicationContext
import com.example.daggerstepbystep.di.DatabaseInfo
import com.example.daggerstepbystep.model.User
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Singleton
import android.content.ContentValues

const val USER_TABLE_NAME = "users"
const val USER_COLUMN_USER_ID = "id"
const val USER_COLUMN_USER_NAME = "usr_name"
const val USER_COLUMN_USER_ADDRESS = "usr_add"
const val USER_COLUMN_USER_CREATED_AT = "created_at"
const val USER_COLUMN_USER_UPDATED_AT = "updated_at"

@Singleton
class DbHelper @Inject constructor(
    @ApplicationContext context: Context,
    @DatabaseInfo dbName: String,
    @DatabaseInfo version: Int
) : SQLiteOpenHelper(context, dbName, null, version) {

    override fun onCreate(db: SQLiteDatabase) {
        createTableIfNotExist(db)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $USER_TABLE_NAME")
        onCreate(db)
    }

    private fun createTableIfNotExist(db: SQLiteDatabase) {
        db.execSQL(
            "CREATE TABLE IF NOT EXISTS "
                    + USER_TABLE_NAME + "("
                    + USER_COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + USER_COLUMN_USER_NAME + " VARCHAR(20), "
                    + USER_COLUMN_USER_ADDRESS + " VARCHAR(50), "
                    + USER_COLUMN_USER_CREATED_AT + " VARCHAR(10) DEFAULT " + getCurrentTimeStamp() + ", "
                    + USER_COLUMN_USER_UPDATED_AT + " VARCHAR(10) DEFAULT " + getCurrentTimeStamp() + ")"
        )
    }

    @SuppressLint("Recycle")
    @Throws(Resources.NotFoundException::class)
    fun getUser(userId: Long): User {
        val cursor = try {
            readableDatabase.rawQuery(
                "SELECT * FROM $USER_TABLE_NAME WHERE $USER_COLUMN_USER_ID = ? ",
                arrayOf(userId.toString())
            )
        } catch (e: Exception) { null }

        if (cursor == null || cursor.count == 0) throw Resources.NotFoundException("User with id $userId does not exists")
        cursor.moveToFirst()
        val user = User(
            cursor.getLong(cursor.getColumnIndex(USER_COLUMN_USER_ID)),
            cursor.getString(cursor.getColumnIndex(USER_COLUMN_USER_NAME)),
            cursor.getString(cursor.getColumnIndex(USER_COLUMN_USER_ADDRESS)),
            cursor.getString(cursor.getColumnIndex(USER_COLUMN_USER_CREATED_AT)),
            cursor.getString(cursor.getColumnIndex(USER_COLUMN_USER_UPDATED_AT))
        )
        cursor.close()
        return user
    }

    @Throws(Exception::class)
    fun insertUser(user: User): Long {
        try {
            val contentValues = ContentValues()
            contentValues.put(USER_COLUMN_USER_NAME, user.name)
            contentValues.put(USER_COLUMN_USER_ADDRESS, user.address)
            return writableDatabase.insert(USER_TABLE_NAME, null, contentValues)
        } catch (e: Exception) {
            e.printStackTrace()
            throw e
        }
    }

    private fun getCurrentTimeStamp(): String {
        return (System.currentTimeMillis() / 1000).toString()
    }
}