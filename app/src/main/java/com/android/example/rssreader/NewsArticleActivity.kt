package com.android.example.rssreader

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.android.example.rssreader.model.Item


class NewsArticleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_article)

        title = ""

        val feedTopic : Item = intent.getParcelableExtra<Item>("feed")!!
        val topicUrl = feedTopic.link


        val title: TextView = findViewById(R.id.articleWordList)
        val description: TextView = findViewById(R.id.description)
        val pubDate: TextView = findViewById(R.id.date)


        pubDate.text = feedTopic.pubDate
        title.text = feedTopic.title
        description.text = feedTopic.description

        fun openWebPage(url: String) {
            val webpage: Uri = Uri.parse(url)
            val intent = Intent(Intent.ACTION_VIEW, webpage)
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }
        }
        findViewById<Button>(R.id.website).setOnClickListener(){
            openWebPage(topicUrl)
        }

        // TODO PHASE 2
    }
}
