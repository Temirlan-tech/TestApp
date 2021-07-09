package com.example.testapp.ui.main

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.testapp.ui.convenience.ConvinienceFragment
import com.example.testapp.ui.grocery.GroceryFragment
import com.example.testapp.ui.pharmacy.PharmacyFragment
import com.example.testapp.ui.takeaways.TakeawaysFragment

class AdapterMain(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int  = 4

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> TakeawaysFragment ()
            1 -> GroceryFragment ()
            2 -> ConvinienceFragment ()
            3 -> PharmacyFragment ()
            else -> Fragment()
        }
    }
}