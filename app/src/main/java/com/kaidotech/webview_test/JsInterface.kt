package com.kaidotech.webview_test

import android.content.Context
import android.os.Build
import android.webkit.JavascriptInterface
import android.widget.Toast


class JsInterface(private val mContext: Context) {

    @JavascriptInterface
    fun getAndroidVersion(): Int {
        return Build.VERSION.SDK_INT
    }

    @JavascriptInterface
    fun addd(name: String, age: String, table_name: String) {
        val db = DBHelper(mContext, null,table_name)
        db.addName(name, age)
    }

    @JavascriptInterface
    fun viewData(table_name: String): String {

        val db = DBHelper(mContext, null, table_name)
        return CursorTOJSON().cur2Json(db.getName())
    }
    @JavascriptInterface
    fun showToast(toast: String) {
        Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show()
    }
}

