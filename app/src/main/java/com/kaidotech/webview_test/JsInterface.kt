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
        fun showToast() {
            Toast.makeText(mContext, "Toast from android", Toast.LENGTH_SHORT).show()
        }
    }

