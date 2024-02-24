package com.example.sqlitetutorial.dao

import android.provider.BaseColumns

object FeedReaderContract {
    object FeedEntry: BaseColumns {
        const val TABLE_NAME = "entry"
        const val COLUMN_ID = "id"
        const val COLUMN_TITLE = "title"
        const val COLUMN_SUBTITLE = "subtitle"
    }

}