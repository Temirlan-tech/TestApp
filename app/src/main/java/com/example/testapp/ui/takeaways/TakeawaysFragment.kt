package com.example.testapp.ui.takeaways

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testapp.R
import com.example.testapp.databinding.FragmentTakeawaysBinding

class TakeawaysFragment : Fragment(),
    OnItemClickListener {

    private var _binding: FragmentTakeawaysBinding? = null
    private val binding get() = _binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentTakeawaysBinding.inflate(inflater,container,false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var listFood: ArrayList<Food> = arrayListOf(
            Food(
                R.drawable.burger2,
                "Burger Craze",
                "   Open",
                " 4.6",
                "(601)",
                "American",
                "  Burgers",
                "Delivery:  Free",
                "   Minimum $10",
                " 10 - 15min",
                "  1,5 km away",
                true,
                "Spend 25\$, save \$5"
            ),
            Food(
                R.drawable.pizza,
                "Vegetarian Pizza",
                "   Open",
                " 4.6",
                "(601)",
                "Italian",
                "  Pizza",
                "Delivery:  Free",
                "   Minimum $10",
                " 10 - 15min",
                "  0,8 km away",
                false,
                "Spend 25\$, save \$5"
            )
        )

        binding?.recyclerView?.apply {
            val adapter: AdapterFoodItem =
                AdapterFoodItem(
                    listFood,
                    this@TakeawaysFragment
                )
            layoutManager = LinearLayoutManager(context)
            this.adapter = adapter
        }
    }

    override fun onItemClick() {
        view?.let { Navigation.findNavController(it).navigate(R.id.detailFragment) }
    }
}