package com.example.meirlen.mtrello.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.meirlen.mtrello.R
import com.example.meirlen.mtrello.utill.ext.toast

class HomeFragment : Fragment() {



    companion object {
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.board_list_fragment, container, false)

    }




}