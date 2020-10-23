package com.w.movies.ui

import android.content.Context
import android.opengl.Visibility
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.w.movies.R
import com.w.movies.interfaces.ImageSetListener
import com.w.movies.interfaces.ItemClickListener
import com.w.movies.model.Results
import com.w.movies.supporting.Utils
import com.w.movies.supporting.baseURlForImage_w342
import com.w.movies.supporting.baseURlForImage_w780
import kotlinx.android.synthetic.main.row_movie.view.*

class MoviesAdapter(private val itemClickListener: ItemClickListener<Results>) : RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    private var moviesAl : List<Results>? = null
    private var ctx : Context? = null

    fun swapValue(moviesAl : List<Results>){
        this.moviesAl = moviesAl
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesAdapter.ViewHolder {
        this.ctx = parent.context
       val inflater =  LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.row_movie,parent,false)
        return ViewHolder(view)

     }

    override fun getItemCount(): Int {
        return this.moviesAl?.count()?:0
    }

    override fun onBindViewHolder(holder: MoviesAdapter.ViewHolder, position: Int) {
        val movie = moviesAl?.get(position)
        movie?.let {
            if (movie.poster_path.isNullOrEmpty()){
                 holder.title.setText(movie.title)
                holder.title.visibility = View.VISIBLE
            }else {

                holder.title.visibility = View.GONE
                Utils.loadImage(ctx = ctx!!, uri = baseURlForImage_w342 + movie.poster_path, imageView = holder.image)
            }
        }
        holder.itemView.setOnClickListener{
            itemClickListener.onItemClick(moviesAl!!.get(holder.adapterPosition))
        }
    }

    class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView ) {
         val image = itemView.image
        val title = itemView.title
      }
}