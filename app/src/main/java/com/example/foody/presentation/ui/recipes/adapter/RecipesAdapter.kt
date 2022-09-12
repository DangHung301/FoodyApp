package com.example.foody.presentation.ui.recipes.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.foody.R
import com.example.foody.domain.model.RecipesModel

class RecipesAdapter(var listRecipes: List<RecipesModel>) :
    RecyclerView.Adapter<RecipesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recipe, parent, false)
        return RecipesViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecipesViewHolder, position: Int) {
        holder.readyInMinutes.text = listRecipes[position].readyInMinutes.toString()
        holder.title.text = listRecipes[position].title
        holder.summary.text = listRecipes[position].summary
        holder.aggregateLikes.text = listRecipes[position].aggregateLikes.toString()

        if (listRecipes[position].vegan) {
            holder.vegan.setImageResource(R.drawable.ic_eco_on)
        } else {
            holder.vegan.setImageResource(R.drawable.ic_eco_off)
        }

        listRecipes[position].image?.let { Glide
            .with(holder.itemView)
            .load(it)
            .into(holder.image); }
    }

    override fun getItemCount(): Int {
        return listRecipes.size
    }
}

class RecipesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var vegan: ImageView
    val aggregateLikes: TextView
    val title: TextView
    var readyInMinutes: TextView
    var image: ImageView
    var summary: TextView

    init {
        vegan = view.findViewById(R.id.ic_eco)
        aggregateLikes = view.findViewById(R.id.txt_heart)
        title = view.findViewById(R.id.txt_title)
        image = view.findViewById(R.id.img_recipes)
        readyInMinutes = view.findViewById(R.id.txt_time)
        summary = view.findViewById(R.id.txt_content)
    }
}
