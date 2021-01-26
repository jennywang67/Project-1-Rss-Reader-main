package com.android.example.rssreader

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.android.example.rssreader.FeedTopic


class TopicListAdapter(private val topicList:List<FeedTopic>) : RecyclerView.Adapter<TopicListAdapter.TopicViewHolder>() {
    class TopicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleView = itemView.findViewById<TextView>(R.id.topic)
    }

    override fun onCreateViewHolder( parent: ViewGroup, viewType: Int): TopicViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.topic_item, parent, false)
        return TopicViewHolder(view)
    }

    override fun getItemCount(): Int {
        return topicList.size
    }

    override fun onBindViewHolder(holder: TopicViewHolder, position: Int) {
        holder.titleView.text = topicList[position].topic

        holder.titleView.setOnClickListener{
            val intent = Intent(holder.itemView.context, FeedActivity::class.java)
            intent.putExtra("feed", topicList[position])
            startActivity(holder.itemView.context, intent, null)
        }
    }


}