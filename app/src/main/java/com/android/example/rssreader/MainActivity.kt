package com.android.example.rssreader

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.example.rssreader.FeedTopic

class MainActivity : AppCompatActivity() {

    private lateinit var adapter : TopicListAdapter
    private val topicFeedList = listOf<FeedTopic>(FeedTopic("Health", "health"),
                                                    FeedTopic("UN Affairs", "un-affairs"),
        FeedTopic("Law and Crime Prevention", "law-and-crime-prevention"),
        FeedTopic("Human Rights", "human-rights"),
        FeedTopic("Humanitarian Aid", "humanitarian-aid"),
        FeedTopic("Climate Change", "climate-change"),
        FeedTopic("Culture and Education", "culture-and-education"),
        FeedTopic("Economic Development", "economic-development"),
        FeedTopic("Women", "women"),
        FeedTopic("Peace and Security", "peace-and-security"),
        FeedTopic("Migrants and Refugees", "migrants-and-refugees"),
        FeedTopic("SDGs", "sdgs"))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "UN News Feeds"
        // ========== PHASE 3 : from here ==========================================================
        // TODO: Add RecyclerView here for all "feeds by topic" options
        //  found on https://news.un.org/en/rss-feeds

        val rvscreen1 = findViewById<RecyclerView>(R.id.topics_rv2)
        rvscreen1.layoutManager= LinearLayoutManager(this)
        adapter = TopicListAdapter(topicFeedList)
        rvscreen1.adapter = adapter
        // ========== PHASE 3 : to here ============================================================


        // ========== PHASE 3 : Remove this section if needed from here ============================
        // TODO: Remove this section
        /* Send User to FeedActivity to view UN News Article by Topic */
        //val topic = FeedTopic("Health", "health")
        // TODO: try switching above line with below and see what happens on FeedActivity Page
        // val topic = FeedTopic("Human Rights", "human-rights")

        //val intent = Intent(this, FeedActivity::class.java)
        //intent.putExtra("feed", topic)
        //this.startActivity(intent)
        // ========== PHASE 3 : to here ============================================================
    }
}
