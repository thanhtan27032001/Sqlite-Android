package com.example.sqlitetutorial.dao

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.sqlitetutorial.dao.FeedReaderContract.FeedEntry
import com.example.sqlitetutorial.domain.Feed

class FeedReaderDbHelper(context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        // If you change the database schema, you must increment the database version.
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "FeedReader.db"

        private const val SQL_CREATE_ENTRIES =
            "CREATE TABLE ${FeedEntry.TABLE_NAME} (" +
                    "${FeedEntry.COLUMN_ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "${FeedEntry.COLUMN_TITLE} TEXT," +
                    "${FeedEntry.COLUMN_SUBTITLE} TEXT)"

        private const val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS ${FeedEntry.TABLE_NAME}"
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_ENTRIES)
    }
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES)
        onCreate(db)
    }

    fun insertNewFeed(feed: Feed): Boolean {
        val db = this.writableDatabase

        val value = ContentValues()
        value.put(FeedEntry.COLUMN_TITLE, feed.title)
        value.put(FeedEntry.COLUMN_SUBTITLE, feed.subTitle)

        val newRowId = db?.insert(FeedEntry.TABLE_NAME, null, value)

        return newRowId?.toInt() != -1
    }

    fun getAllFeed(): Cursor {
        val db = this.readableDatabase
        return db.rawQuery("SELECT * FROM ${FeedEntry.TABLE_NAME}", null)
    }
}