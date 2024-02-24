package com.example.sqlitetutorial

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sqlitetutorial.domain.Feed
import com.example.sqlitetutorial.repository.FeedReaderRepository

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        testWriteDatabase()
        testReadDatabase()
    }

    private fun testWriteDatabase() {
        FeedReaderRepository.addFeed(this, Feed("Feed 6", "Sub title here"))
        FeedReaderRepository.addFeed(this, Feed("Feed 7", "Sub title here"))
        FeedReaderRepository.addFeed(this, Feed("Feed 8", "Sub title here"))
        FeedReaderRepository.addFeed(this, Feed("Feed 9", "Sub title here"))
        FeedReaderRepository.addFeed(this, Feed("Feed 10", "Sub title here"))
    }

    private fun testReadDatabase() {
        val feedList = FeedReaderRepository.getAllFeed(this)
        feedList.forEach { feed ->
            println(feed.title)
        }
    }
}