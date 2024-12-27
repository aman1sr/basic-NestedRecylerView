package com.aman.basearchsetup

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.aman.basearchsetup.adapter.ParentHouseAdapter
import com.aman.basearchsetup.databinding.ActivityMainBinding
import com.aman.basearchsetup.model.got.GOTResponse
import com.aman.basearchsetup.utils.Util
import kotlinx.coroutines.launch

const val TAG = "BASE_ARCH_d"

class MainActivity : AppCompatActivity() {
    val viewModel: NewsViewModel by viewModels()
    var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        observeData()
        supportActionBar?.title = "Basic Nested RecylerView"
        readCustomGOTjsonData()
    }

    private fun readCustomGOTjsonData() {
        val gotJSONData = Util.readJsonFromAssets(this@MainActivity, "got_quotes.json")
        val gotResponse: GOTResponse = Util.parseJsonToModel<GOTResponse>(gotJSONData)
        Log.d(TAG, "readCustomGOTjsonData: ${gotJSONData.toString()}")
        setUpParentHouseAdatper(gotResponse)
    }

    private fun setUpParentHouseAdatper(gotResponse: GOTResponse) {
        val adapter = ParentHouseAdapter()
        adapter.submitList(gotResponse)
        binding?.parentRecyclerView?.layoutManager = LinearLayoutManager(this@MainActivity)
        binding?.parentRecyclerView?.adapter = adapter

    }

    private fun observeData() {
        lifecycleScope.launch {
            viewModel?.data?.collect {
                // observe data here
            }
        }
    }
}