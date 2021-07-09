package com.example.testapp.ui.home

import android.annotation.SuppressLint
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.testapp.base.BaseFragment
import com.example.testapp.databinding.FragmentHomeBinding
import com.example.testapp.databinding.IncludeHomeBinding
import com.example.testapp.ui.main.MainFragment

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(FragmentHomeBinding::inflate,
    HomeViewModel::class.java)
{

    private lateinit var uiBinding: IncludeHomeBinding

    override fun setupLiveData() {

    }

    @SuppressLint("ClickableViewAccessibility")
    override fun setupUI() {
        uiBinding = binding.includeHome

        val fragment: Fragment = MainFragment()
        val fragmentManager = activity?.supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager?.beginTransaction()!!
        fragmentTransaction.replace(uiBinding.frameLayout.id, fragment)
        fragmentTransaction.commit()

        uiBinding.editText.setOnTouchListener(View.OnTouchListener { v, event ->
            val size = 2
            if (event.action == MotionEvent.ACTION_UP) {
                if (event.rawX >= uiBinding.editText.right - uiBinding.editText.compoundDrawables[size].bounds.width()
                ) {
                    Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
                    return@OnTouchListener true
                }
            }
            false
        })
    }
}