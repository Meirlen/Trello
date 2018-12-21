package com.example.meirlen.mtrello.ui.custom

import com.google.android.material.tabs.TabLayout


interface SimpleOnTabSelectedListener : TabLayout.OnTabSelectedListener {

    override fun onTabReselected(tab: TabLayout.Tab) {
    }

    override fun onTabUnselected(tab: TabLayout.Tab) {
    }

    override fun onTabSelected(tab: TabLayout.Tab) {
    }
}