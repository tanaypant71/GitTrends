package com.example.gittrends

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gittrends.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.Locale

class MainActivity : AppCompatActivity() {

    //here I am creating a RepoAdapter Instance
    val repoAdapter = RepoAdapter()

    var originalList: List<ItemsItem> = emptyList()

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
                   originalList = it?.items as List<ItemsItem>
                    repoAdapter.swapData(originalList)
                }
            }
            else{   //else showing error message
                Toast.makeText(this@MainActivity,"Error in Request",Toast.LENGTH_SHORT).show()
            }
        }

        binding.etSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //Not needed here
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val query = p0.toString().toLowerCase(Locale.ROOT)
                val filteredList = originalList.filter {
                    it.name?.toLowerCase(Locale.ROOT)?.contains(query) == true
                }
                repoAdapter.swapData(filteredList)

                if(filteredList.isEmpty()){
                    Toast.makeText(this@MainActivity, "No data found", Toast.LENGTH_SHORT).show()
                }
                else{
                    repoAdapter.swapData(filteredList)
                }
            }

            override fun afterTextChanged(p0: Editable?) {
                //Not needed here
            }

        })

    }
}