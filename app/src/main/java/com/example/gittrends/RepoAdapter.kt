package com.example.gittrends

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gittrends.databinding.ListItemReposBinding

class RepoAdapter() : RecyclerView.Adapter<RepoAdapter.RepoHolder>() {

    var list : List<ItemsItem> = arrayListOf()  // List to hold GitHub repository data


    //holds references to the views that are to be displayed i.e. repository data
    inner class RepoHolder(val binding: ListItemReposBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ItemsItem) {
            // Bind data to the ViewHolder's views
            binding.tvRepoName.text = item.name //Set the repository name
            binding.tvRepoDescription.text = item.description // Set the short repository description
            val url = item.owner?.avatarUrl
            // load an image from a URL into an ImageView
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
        // Inflate the layout and create a ViewHolder
        return RepoHolder(ListItemReposBinding.bind(LayoutInflater.from(parent.context).
                inflate(R.layout.list_item_repos,parent,false)))
    }

    override fun onBindViewHolder(holder: RepoHolder, position: Int) {
        // Bind data to the ViewHolder
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size    // Return the number of items in the list

    fun swapData(newData: List<ItemsItem>) {
        //updating the list with the new data ,
        // also notify the adapter that new new data is fetched
        this.list = newData
        notifyDataSetChanged()
    }
}