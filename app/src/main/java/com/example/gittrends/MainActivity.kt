package com.example.gittrends

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gittrends.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    //here I am creating a RepoAdapter Instance
    val repoAdapter = RepoAdapter()

    //this is my onCreate Method which is called when the activity is created
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)  // Creating a layout binding
        setContentView(binding.root)  // Setting the content view to the root view of layout

        binding.rvRepos.apply { // Recycler view set up
            layoutManager = LinearLayoutManager(this@MainActivity)  // Using LinearLayoutManager
            adapter = this@MainActivity.repoAdapter  // Setting the adapter
        }

        //Starting a coroutine in the main UI thread
        GlobalScope.launch(Dispatchers.Main) {
            val response = withContext(Dispatchers.IO){Client.api.getRepos()}  //Making network request

            if (response.isSuccessful) { //checking network request
                response.body().let { //extract the response
                    if (it != null) {
                        repoAdapter.swapData(it.items as List<ItemsItem>)  //updating the adapter with new data
                    }
                }
            }
            else{   //else showing error message
                Toast.makeText(this@MainActivity,"Error in Request",Toast.LENGTH_SHORT).show()
            }
        }
    }
}