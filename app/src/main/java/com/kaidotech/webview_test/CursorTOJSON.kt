package com.kaidotech.webview_test

import android.content.ContentValues.TAG
import android.database.Cursor
import android.util.Log
import org.json.JSONArray
import org.json.JSONObject


class CursorTOJSON {
    fun cur2Json(cursor: Cursor): String {
        val resultSet = JSONArray()
        cursor.moveToFirst()
        while (cursor.isAfterLast() === false) {
            val totalColumn: Int = cursor.columnCount
            val rowObject = JSONObject()
            for (i in 0 until totalColumn) {
                if (cursor.getColumnName(i) != null) {
                    try {
                        rowObject.put(
                            cursor.getColumnName(i),
                            cursor.getString(i)
                        )
                    } catch (e: Exception) {
                        e.message?.let { Log.d(TAG, it) }
                    }
                }
            }
            resultSet.put(rowObject)
            cursor.moveToNext()
        }
        cursor.close()
        return resultSet.toString()
    }
}
