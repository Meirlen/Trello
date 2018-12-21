package com.example.meirlen.mtrello

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.meirlen.mtrello.ext.replaceByTag
import com.example.meirlen.mtrello.ui.fragments.BoardsFragment
import com.example.meirlen.mtrello.ui.custom.SimpleOnTabSelectedListener
import com.example.meirlen.mtrello.ui.fragments.HomeFragment
import com.example.meirlen.mtrello.ui.fragments.ProfileFragment
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){

    companion object {

        private const val CURRENT_SCREEN = "current_screen"

        const val HOME = 0
        const val SEARCH = 1
        const val SHARE = 2
        const val FAVOURITE = 3
        const val PROFILE = 4

        fun getStartIntent(context: Context, isNewTask: Boolean = false): Intent {
            val intent = Intent(context, MainActivity::class.java)
            if (isNewTask) {
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            }
            return intent
        }
    }

    private var currentScreen: Int = HOME



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        currentScreen = savedInstanceState?.getInt(CURRENT_SCREEN, HOME) ?: HOME
        setupNavigation()
        switchFragment(currentScreen)

    }

    private fun setupNavigation() {
        bottomTabNavigation.getTabAt(currentScreen)?.select()
        bottomTabNavigation.addOnTabSelectedListener(object : SimpleOnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                switchFragment(tab.position)
            }
        })
    }

    private fun switchFragment(position: Int) {
        currentScreen = position
        supportFragmentManager.replaceByTag(R.id.frame_container, position.toString(), {
            when (position) {
                HOME -> BoardsFragment()
                SEARCH -> HomeFragment()
                SHARE -> BoardsFragment()
                FAVOURITE -> BoardsFragment()
                PROFILE -> ProfileFragment()
                else -> BoardsFragment()
            }
        }).commit()
    }



}
