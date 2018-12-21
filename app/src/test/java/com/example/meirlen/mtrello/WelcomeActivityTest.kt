package com.example.meirlen.mtrello


import android.os.Build
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

import org.junit.Assert.assertNotNull
import android.widget.LinearLayout
import android.widget.TextView
import org.junit.Assert.assertEquals


@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.O_MR1])
class WelcomeActivityTest {
    private lateinit var activity: WelcomeActivity

    @Before
    @Throws(Exception::class)
    fun setUp() {
        activity = Robolectric.buildActivity(WelcomeActivity::class.java)
                .create()
                .resume()
                .get()
    }

    @Test
    @Throws(Exception::class)
    fun shouldHaveDefaultMargin() {
        val textView = activity!!.findViewById(R.id.hello_textview) as TextView
        val bottomMargin = (textView.layoutParams as LinearLayout.LayoutParams).bottomMargin
        assertEquals(5, bottomMargin)
        val topMargin = (textView.layoutParams as LinearLayout.LayoutParams).topMargin
        assertEquals(5, topMargin)
        val rightMargin = (textView.layoutParams as LinearLayout.LayoutParams).rightMargin
        assertEquals(10, rightMargin)
        val leftMargin = (textView.layoutParams as LinearLayout.LayoutParams).leftMargin
        assertEquals(10, leftMargin)
    }
}