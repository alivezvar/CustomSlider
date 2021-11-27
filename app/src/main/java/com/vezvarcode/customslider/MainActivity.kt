package com.vezvarcode.customslider

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import com.vezvarcode.customslider.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        createSlider()

    }

    private fun createSlider() {
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerView.layoutManager = layoutManager
        val adapter = SliderAdapter()
        binding.recyclerView.adapter = adapter


        val helper = PagerSnapHelper()
        helper.attachToRecyclerView(binding.recyclerView)


        binding.indicator.attachToRecyclerView(binding.recyclerView, helper)
        adapter.registerAdapterDataObserver(binding.indicator.adapterDataObserver)


        adapter.addData(
            arrayListOf(
                "https://s.alicdn.com/@img/imgextra/i2/O1CN01PpjFEt1P2etnLQdXu_!!6000000001783-0-tps-990-400.jpg",
                "https://s.alicdn.com/@img/imgextra/i3/O1CN01QEL53b1ZNOzSa5hHT_!!6000000003182-0-tps-990-400.jpg",
                "https://s.alicdn.com/@img/tfs/TB1e.XyReL2gK0jSZFmXXc7iXXa-990-400.png",
            )
        )


        adapter.listener = object : AdapterListener {
            override fun onItemClick(position: Int, image: String) {
                Toast.makeText(this@MainActivity, "$position Clicked !", Toast.LENGTH_SHORT).show()
            }
        }
    }
}