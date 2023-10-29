package com.example.gittrends

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gittrends.databinding.ListItemReposBinding

class RepoAdapter() : RecyclerView.Adapter<RepoAdapter.RepoHolder>() {

    var list : List<ItemsItem> = arrayListOf()



    inner class RepoHolder(val binding: ListItemReposBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ItemsItem) {
            binding.tvRepoName.text = item.name
            binding.tvRepoDescription.text = item.description // Set the short description here
            val url = item.owner?.avatarUrl
            Glide.with(itemView.context).load(url).placeholder(R.drawable.repos).into(binding.ivRepo)

            // Set a click listener for the "Open Repository" button
            binding.btnOpenRepo.setOnClickListener {
                val intent = Intent(it.context, SingleRepoActivity::class.java)

                // Pass data to the detail activity
                item.stargazersCount?.let { it1 -> intent.putExtra("StarCount", it1) }
                intent.putExtra("Readme", item.description.toString())
                intent.putExtra("Readme", item.description)
                intent.putExtra("RepoName", item.name)
                intent.putExtra("OwnerName", item.owner?.login)
                intent.putExtra("HtmlUrl", item.htmlUrl)


                it.context.startActivity(intent)
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoHolder {
        return RepoHolder(ListItemReposBinding.bind(LayoutInflater.from(parent.context).
                inflate(R.layout.list_item_repos,parent,false)))
    }

    override fun onBindViewHolder(holder: RepoHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    fun swapData(newData: List<ItemsItem>) {
        this.list = newData
        notifyDataSetChanged()
    }
}