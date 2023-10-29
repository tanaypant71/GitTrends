package com.example.gittrends

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gittrends.databinding.ActivitySingleRepoBinding

class SingleRepoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivitySingleRepoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val starCount = intent.getIntExtra("StarCount",1220)
        val readMe = intent.getStringExtra("Readme")
        val repoName = intent.getStringExtra("RepoName")
        val ownerName = intent.getStringExtra("OwnerName")
        val htmlUrl = intent.getStringExtra("HtmlUrl")

        binding.tvStarCount.text = starCount.toString()
        binding.tvReadme.text = readMe
        binding.tvRepoName.text = repoName
        binding.tvOwnerName.text = ownerName

        binding.btnOpenGitHub.setOnClickListener {
            val openGitHubIntent = Intent(Intent.ACTION_VIEW, Uri.parse(htmlUrl))
            startActivity(openGitHubIntent)
        }
    }
}