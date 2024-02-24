package com.example.sqlitetutorial.repository

import android.content.Context
import com.example.sqlitetutorial.dao.FeedReaderDbHelper
import com.example.sqlitetutorial.domain.Feed

class FeedReaderRepository {
    companion object {
        fun addFeed(context: Context, feed: Feed) {
            val db = FeedReaderDbHelper(context)
            db.insertNewFeed(feed)
        }

        fun getAllFeed(context: Context): ArrayList<Feed> {
            val db = FeedReaderDbHelper(context)
            val feedList = arrayListOf<Feed>()
            val cursor = db.getAllFeed()
            while (cursor.moveToNext()) {
                feedList.add(Feed(cursor.getString(1), cursor.getString(2)))
            }
            return feedList
        }
    }
}