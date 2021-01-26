package com.android.example.rssreader

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.android.example.rssreader.model.Item


class ArticleListAdapter(private val articleWordList:MutableList<Item>) : RecyclerView.Adapter<ArticleListAdapter.ArticleViewHolder>() {
    class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val dateView = itemView.findViewById<TextView>(R.id.date)
        val articleView = itemView.findViewById<TextView>(R.id.article)
        val blurbView = itemView.findViewById<TextView>(R.id.blurb)
        val linearLayoutView = itemView.findViewById<LinearLayout>(R.id.article_item)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ArticleViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.article_item, parent, false)
        return ArticleViewHolder(view)
    }

    override fun getItemCount(): Int {
        return articleWordList.size
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.dateView.text = articleWordList[position].pubDate
        holder.articleView.text = articleWordList[position].title
        holder.blurbView.text = articleWordList[position].description

        holder.linearLayoutView.setOnClickListener{
            val intent = Intent(holder.itemView.context, NewsArticleActivity::class.java)
            intent.putExtra("feed", articleWordList[position])
            startActivity(holder.itemView.context, intent, null)
        }
    }

    fun reset(){
        notifyDataSetChanged()
    }
}