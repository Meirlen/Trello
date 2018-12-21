package com.example.meirlen.mtrello.ui.board

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.meirlen.mtrello.R
import com.example.meirlen.mtrello.base.BaseFragment
import com.example.meirlen.mtrello.utill.ext.toast
import com.example.meirlen.mtrello.utill.interfaces.ItemClickListener
import com.example.meirlen.mtrello.data.datasource.entities.Board
import com.example.meirlen.mtrello.ui.board.list.BoardsAdapter
import kotlinx.android.synthetic.main.board_list_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class BoardsFragment : BaseFragment<List<Board>>(), ItemClickListener<Board> {
    override fun onResponse(response: List<Board>) {
    }

    override fun getContentView(): Int {
        return R.layout.board_list_fragment;
    }


    val TAG = javaClass.simpleName

    val model: BoardViewModel by viewModel()

    private lateinit var mAdapter: BoardsAdapter



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mAdapter = BoardsAdapter(this)
        mRecyclerView.layoutManager = LinearLayoutManager(context)
        mRecyclerView.adapter = mAdapter

        model.getBoards()

        model.uiData.observe(this, Observer<List<Board>> {
            if (it != null) {
                context?.toast(it.size.toString())
                mAdapter.setData(it as ArrayList<Board>)
            }
        })

        model.searchEvent.observe(this, Observer(function = fun(searchEvent: BoardViewModel.SearchEvent?) {
            if (searchEvent != null) {
                if (searchEvent.isLoading) {
                    // displayProgress()
                } else {
                    // displayNormal()
                    if (searchEvent.isSuccess) {

                    } else if (searchEvent.error != null) {
                        context?.toast(searchEvent.error)
                        Log.d("ErCase",searchEvent.error)
                    }
                }
            }
        }))


    }

    override fun onItemClick(dataObject: Board) {
        // router.showColumns(context, dataObject.id)
        // toast(dataObject.id)
    }

}