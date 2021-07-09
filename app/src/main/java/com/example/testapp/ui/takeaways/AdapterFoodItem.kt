package com.example.testapp.ui.takeaways
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testapp.databinding.ItemMainBinding


class AdapterFoodItem(
    private val listFood: ArrayList<Food>, private val onItemClickListener: OnItemClickListener
) : RecyclerView.Adapter<AdapterFoodItem.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemMainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(
            binding
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(listFood[position])
        holder.itemView.setOnClickListener {
            onItemClickListener.onItemClick()
        }
    }

    override fun getItemCount() = listFood.size

    class ViewHolder(private var binding: ItemMainBinding) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(food: Food) {
            binding.textViewTypeFood.text = food.name
            binding.textViewOpen.text = food.status
            binding.textViewReview.text = food.review
            binding.textViewReviewAmount.text = food.reviewAmount
            binding.textViewCountry.text = food.country
            binding.textViewFoodKind.text = food.foodKind
            binding.textViewDeliveryCost.text = food.deliveryCost
            binding.textViewMinMax.text = food.minMax
            binding.btnTimeDelivery.text = food.deliveryTime
            binding.textViewDistance.text = food.distance
            food.image?.let { binding.imageView.setImageResource(it) }
            if (food.isOffered!!) binding.containerOffer.visibility = View.VISIBLE; binding.textViewOffer.text = food.offerText
        }
    }
}

data class Food(
    var image: Int,
    var name: String,
    var status: String,
    var review: String,
    var reviewAmount: String,
    var country: String,
    var foodKind: String,
    var deliveryCost: String,
    var minMax: String,
    var deliveryTime: String,
    var distance: String,
    var isOffered: Boolean,
    var offerText: String
)

interface OnItemClickListener{
    fun onItemClick()
}