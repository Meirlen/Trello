package com.example.meirlen.mtrello.ui.board.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.meirlen.mtrello.R
import com.example.gateway.entity.Board
import com.example.meirlen.mtrello.utill.interfaces.ItemClickListener
import com.example.meirlen.mtrello.utill.ext.loadImage
import kotlinx.android.synthetic.main.item_board.view.*

class BoardsAdapter(private var listener: ItemClickListener<Board>) : RecyclerView.Adapter<BoardsAdapter.MovieViewHolder>() {

    private var mMovieList: ArrayList<Board> = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_board, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val board = mMovieList[position]
        holder.itemView.txtTitle!!.text = board.name
        holder.itemView.setOnClickListener { listener.onItemClick(board)}
        holder.itemView.coverImageView.loadImage("https://pp.userapi.com/c841322/v841322681/5f307/sEetuxRTuIg.jpg")
    }

    override fun getItemCount(): Int {
        return mMovieList.size
    }

    fun setData(movieList: ArrayList<Board>) {
        mMovieList = movieList
        notifyDataSetChanged()
    }

    fun clearAdapter() {
        mMovieList.clear()
        notifyDataSetChanged()
    }

    inner class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val view = this.itemView
    }

}