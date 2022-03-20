package com.example.newstoday

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class NewsListAdapter(private val listener: NewsItemClicked): RecyclerView.Adapter<NewsViewHolder>() {

    private val item: ArrayList<News> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news,parent,false)
        val viewHolder = NewsViewHolder(view)
        view.setOnClickListener {
            listener.onItemClicked(item[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val currentItem = item[position]
        if (currentItem.title!="null"){
            holder.titleView.text = currentItem.title
            holder.author.text = "Source : "+ currentItem.author
            holder.description.text = currentItem.description
            Glide.with(holder.itemView.context).load(currentItem.imageUrl).into(holder.image)
        }
    }

    override fun getItemCount(): Int {
        return item.size
    }

    fun updateNews(updatedNews: ArrayList<News>){
        item.clear()
        item.addAll(updatedNews)

        notifyDataSetChanged()
    }
}

class NewsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val titleView: TextView = itemView.findViewById(R.id.title)
    val image:ImageView = itemView.findViewById(R.id.image)
    val author: TextView = itemView.findViewById(R.id.author)

    val description: TextView = itemView.findViewById(R.id.description)
}

interface NewsItemClicked{
    fun onItemClicked(item: News)
}