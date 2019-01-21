package com.example.meirlen.mtrello.ui.column

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.meirlen.mtrello.R
import com.example.gateway.entity.Column
import com.example.meirlen.mtrello.utill.interfaces.ItemClickListener
import kotlinx.android.synthetic.main.item_column.view.*

class ColumnAdapter(private  val context: Context, private var listener: ItemClickListener<Column>) : RecyclerView.Adapter<ColumnAdapter.MovieViewHolder>() {

    private var mMovieList: ArrayList<Column> = ArrayList()
    private val TAG_ADAPTER = "ColumnAdapter"


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_column, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val column = mMovieList[position]
        holder.itemView.txtTitle.text = column.name
        holder.itemView.setOnClickListener { listener.onItemClick(column) }
        holder.itemView.linearLayoutItems.removeAllViews()
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        /*column.cards.forEach {
            val child = inflater.inflate(R.layout.item_card, null)
            val textViewTitle = child.txtTitle as TextView
            textViewTitle.text = it.name
            holder.itemView.linearLayoutItems.addView(child)
        }*/
    }

    override fun getItemCount(): Int {
        return mMovieList.size
    }

    fun setData(movieList: ArrayList<Column>) {
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