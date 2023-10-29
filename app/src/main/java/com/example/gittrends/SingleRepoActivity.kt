package com.example.gittrends

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gittrends.databinding.ActivitySingleRepoBinding

class SingleRepoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate the layout for this activity
        val binding = ActivitySingleRepoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Retrieving data from the previous activity , also giving some default values
        val starCount = intent.getIntExtra("StarCount",1220)
        val readMe = intent.getStringExtra("Readme")
        val repoName = intent.getStringExtra("RepoName")
        val ownerName = intent.getStringExtra("OwnerName")
        val htmlUrl = intent.getStringExtra("HtmlUrl")

        //Setting the retrieved data to the respective TextViews in the layout
        binding.tvStarCount.text = starCount.toString()
        binding.tvReadme.text = readMe
        binding.tvRepoName.text = repoName
        binding.tvOwnerName.text = ownerName

        //click listener for the "Open on GitHub" button
        binding.btnOpenGitHub.setOnClickListener {
            val openGitHubIntent = Intent(Intent.ACTION_VIEW, Uri.parse(htmlUrl))
            startActivity(openGitHubIntent)
        }
    }
}