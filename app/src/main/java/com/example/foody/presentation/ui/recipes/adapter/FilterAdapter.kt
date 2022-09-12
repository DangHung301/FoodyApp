package com.example.foody.presentation.ui.recipes.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.foody.R
import com.example.foody.domain.local.app_const.OnItemActionListener
import com.example.foody.domain.model.FilterModel
import com.example.foody.presentation.untils.extension.copyWith

class FilterAdapter(private val listOption: MutableList<FilterModel>) :
    RecyclerView.Adapter<FilterViewHolder>() {
    lateinit var view: View
    lateinit var onItemActionListener: OnItemActionListener

    fun setActionListener(param: OnItemActionListener) {
        onItemActionListener = param
    }

    fun updateData(options: MutableList<FilterModel>) {
        listOption.clear()
        listOption.addAll(options)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilterViewHolder {
        view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_filter_widget, parent, false)
        return FilterViewHolder(view, onItemActionListener)
    }

    override fun onBindViewHolder(holder: FilterViewHolder, position: Int) {
        holder.txtOption.text = listOption[position].option

        if (listOption[position].state) {
            holder.element.setBackgroundResource(R.drawable.bgr_item_filter_selected)
            holder.txtOption.setTextColor(R.color.purplish_blue.copyWith(view.context))
        } else {
            holder.element.setBackgroundResource(R.drawable.bgr_item_filter_no_selected)
            holder.txtOption.setTextColor(R.color.grey.copyWith(view.context))
        }
    }

    override fun getItemCount(): Int {
        return listOption.size
    }
}

class FilterViewHolder(view: View, onclickItem: OnItemActionListener) :
    RecyclerView.ViewHolder(view) {
    val txtOption: TextView = view.findViewById(R.id.txt_option)
    val element: ConstraintLayout = view.findViewById(R.id.element_filter)

    init {
        view.setOnClickListener {
            onclickItem.onTap(view, adapterPosition)
        }

        view.setOnLongClickListener {
            onclickItem.onLongTap(view, adapterPosition)
            true
        }
    }
}
