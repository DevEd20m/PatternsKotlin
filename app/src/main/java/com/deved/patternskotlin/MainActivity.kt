package com.deved.patternskotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.deved.patternskotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        OrderCommandProcesor.initFragments()
        setUpNavigationView()
    }

    private fun setUpNavigationView() {
        OrderCommandProcesor.setFragmentManager(this)
        binding.bottomNavigationView.inflateMenu(R.menu.bottom_navigation_menu)
        binding.bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            OrderCommandProcesor.processFragment(menuItem.itemId)
            return@setOnNavigationItemSelectedListener true
        }
        binding.bottomNavigationView.selectedItemId = R.id.itemHome
    }

    override fun onDestroy() {
        OrderCommandProcesor.clearCommand()
        super.onDestroy()
    }
}
