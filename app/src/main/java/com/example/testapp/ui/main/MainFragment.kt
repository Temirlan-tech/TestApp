package com.example.testapp.ui.main

import androidx.viewpager2.widget.ViewPager2
import com.example.testapp.R
import com.example.testapp.base.BaseFragment
import com.example.testapp.databinding.FragmentMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainFragment : BaseFragment<FragmentMainBinding, MainViewModel>(FragmentMainBinding::inflate, MainViewModel::class.java) {

    private lateinit var viewPager: ViewPager2

    override fun setupLiveData() {
    }

    override fun setupUI() {
        viewPager = binding.viewPager
        viewPager.adapter = AdapterMain(this)

        TabLayoutMediator(binding.tabLayoutMainFragment, viewPager) { tab, position ->
            when (position) {
                0 ->  tab.setCustomView( R.layout.take_away_view )
                1 ->  tab.setCustomView(R.layout.grocery_view)
                2 ->  tab.setCustomView(R.layout.convenience_view)
                3 ->  tab.setCustomView(R.layout.pharmacy_view)
            }
        }.attach()
    }

}