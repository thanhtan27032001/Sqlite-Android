package com.example.sqlitetutorial

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        testWriteDatabase()
        testReadDatabase()
    }

    private fun testWriteDatabase() {
        val db = FeedReaderDbHelper(this)
        db.insertNewFeed("Feed 1", "Sub title here")
        db.insertNewFeed("Feed 2", "Sub title here")
        db.insertNewFeed("Feed 3", "Sub title here")
        db.insertNewFeed("Feed 4", "Sub title here")
        db.insertNewFeed("Feed 5", "Sub title here")
    }

    private fun testReadDatabase() {
        val db = FeedReaderDbHelper(this)
        val cursor = db.getAllFeed()
        while (cursor.moveToNext()) {
            println(cursor.getString(1))
        }
    }
}