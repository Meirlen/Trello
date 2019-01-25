package com.example.meirlen.mtrello.ui.board


import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.gateway.entity.Board
import kotlinx.android.synthetic.main.board_list_fragment.*
import com.example.meirlen.mtrello.R
import com.example.meirlen.mtrello.base.ui.BaseFragment
import com.example.meirlen.mtrello.base.vo.Status
import com.example.meirlen.mtrello.ui.board.list.BoardsAdapter
import com.example.meirlen.mtrello.utill.interfaces.ItemClickListener
import org.koin.androidx.viewmodel.ext.android.getViewModel

import org.koin.androidx.viewmodel.ext.android.viewModel

class BoardsFragment : BaseFragment<List<Board>>(), ItemClickListener<Board> {


    val TAG = javaClass.simpleName
    lateinit var mViewModel: BoardViewModel
    private lateinit var mAdapter: BoardsAdapter

    companion object {
        fun newInstance(): BoardsFragment {
            return BoardsFragment()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewModel = getViewModel()
        mAdapter = BoardsAdapter(this)
        mRecyclerView.layoutManager = LinearLayoutManager(context)
        mRecyclerView.adapter = mAdapter

        mViewModel.getBoards()
        mViewModel.getBoards().observe(this, Observer {
            when (it?.status) {
                Status.LOADING -> {
                    displayProgress()
                }
                Status.SUCCESS -> {
                    Log.d(TAG, "--> Success! | loaded ${it.data?.size ?: 0} records.")
                    displayNormal()
                    mAdapter.setData(it.data as ArrayList<Board>)
                }
                Status.ERROR -> {
                    toast("Error: ${it.message}")
                }
            }
        })
    }

    private fun displayNormal() {
        boardProgressBar.visibility = View.GONE
    }

    private fun displayProgress() {
        boardProgressBar.visibility = View.VISIBLE
    }

    override fun onItemClick(dataObject: Board) {
        router.showColumns(context, dataObject.id)
    }

    override fun onResponse(response: List<Board>) {
    }

    override fun getContentView(): Int {
        return R.layout.board_list_fragment
    }

}