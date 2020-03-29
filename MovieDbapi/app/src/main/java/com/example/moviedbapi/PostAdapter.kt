package com.example.moviedbapi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PostAdapter(
    var list: List<Post>? = null,
    val itemClickListener: RecyclerViewItemClick? = null
    ) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): PostViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.item_post, p0, false)
        return PostViewHolder(view)
    }

    override fun getItemCount(): Int = list?.size ?: 0

    override fun onBindViewHolder(p0: PostViewHolder, p1: Int) {
        p0.bind(list?.get(p1))
    }

    fun clearAll() {
        (list as? ArrayList<Post>)?.clear()
        notifyDataSetChanged()
    }

    inner class PostViewHolder(val view: View): RecyclerView.ViewHolder(view) {

        fun bind(post: Post?) {
            val tvTitle = view.findViewById<TextView>(R.id.tvTitle)
            val tvPostId = view.findViewById<TextView>(R.id.tvPostId)
            val tvOriginalTitle = view.findViewById<TextView>(R.id.tvOriginalTitle)
            val tvReleaseDate = view.findViewById<TextView>(R.id.tvReleaseDate)
            val tvRating = view.findViewById<TextView>(R.id.tvRating)
            val tvVoteCount = view.findViewById<TextView>(R.id.tvVoteCount)

            tvTitle.text = post?.title
            tvPostId.text = post?.movieId.toString()
            tvOriginalTitle.text = post?.originalTitle
            tvRating.text = post?.rating.toString()
            tvReleaseDate.text = post?.releaseDate.toString()
            tvVoteCount.text = post?.voteCount.toString()

            view.setOnClickListener {
                itemClickListener?.itemClick(adapterPosition, post!!)
            }
        }
    }

    interface RecyclerViewItemClick {

        fun itemClick(position: Int, item: Post)
    }
}