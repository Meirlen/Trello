package com.example.meirlen.mtrello.ui.board

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.annotation.StringRes
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.domain.exception.Failure
import com.example.meirlen.mtrello.R
import com.example.meirlen.mtrello.base.ui.BaseFragment
import com.example.meirlen.mtrello.base.vo.Status
import com.example.meirlen.mtrello.utill.interfaces.ItemClickListener
import com.example.gateway.entity.Board
import com.example.meirlen.mtrello.ui.board.list.BoardsAdapter
import com.example.meirlen.mtrello.utill.ext.failure
import com.example.meirlen.mtrello.utill.ext.observe
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.board_list_fragment.*
import kotlinx.android.synthetic.main.view_lce_loading.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class BoardsFragment : BaseFragment<List<Board>>(), ItemClickListener<Board> {


    val TAG = javaClass.simpleName
    private val model: BoardViewModel by viewModel()
    private lateinit var mAdapter: BoardsAdapter

    companion object {
        fun newInstance(): BoardsFragment {
            return BoardsFragment()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mAdapter = BoardsAdapter(this)
        mRecyclerView.layoutManager = LinearLayoutManager(context)
        mRecyclerView.adapter = mAdapter

        model.getBoards()
        model.uiData.observe(this, Observer(this@BoardsFragment::renderList))
        model.failure.observe(this, Observer(this@BoardsFragment::handleFailure))

    }

    private fun renderList(movies: List<Board>?) {
        mAdapter.setData(movies as ArrayList<Board>)
    }

    private fun handleFailure(failure: Failure?) {
        when (failure) {
            is Failure.NetworkConnection -> renderFailure(getString(R.string.failure_network_connection))
            is Failure.ServerError -> renderFailure(getString(R.string.failure_server_error))
        }
    }

    private fun renderFailure(message: String) {
        toast(message)

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