package com.dotanphu.testapifood.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dotanphu.testapifood.databinding.ItemListFoodBinding
import com.dotanphu.testapifood.model.Category

class CategoryAdapter(private var listCategory: List<Category>) :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryAdapter.ViewHolder {
        return ViewHolder(
            ItemListFoodBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CategoryAdapter.ViewHolder, position: Int) {
        holder.bind(listCategory[position])
    }

    override fun getItemCount() = listCategory.size

    class ViewHolder(private var binding: ItemListFoodBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(category: Category) {
            binding.tvIdCategory.text = category.idCategory
            binding.tvStrCategory.text = category.strCategory
            binding.tvStrCategoryThumb.text = category.strCategoryThumb
            binding.tvStrCategoryDescription.text = category.strCategoryDescription
        }
    }
}