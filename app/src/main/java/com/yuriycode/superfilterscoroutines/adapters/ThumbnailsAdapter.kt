package com.yuriycode.superfilterscoroutines.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.yuriycode.superfilterscoroutines.R
import com.yuriycode.superfilterscoroutines.model.FilterItem
import com.yuriycode.superfilterscoroutines.model.MySuperFilter

class ThumbnailsAdapter(
    private val thumbnailItemList: List<FilterItem>,
    private val listener: ThumbnailsAdapterListener
) :
    RecyclerView.Adapter<ThumbnailsAdapter.MyViewHolder>() {
    private var selectedIndex = 0
    class MyViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        internal var image: ImageView = v.findViewById(R.id.thumbnail)
        internal var filterName: TextView = v.findViewById(R.id.filter_name)
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_filter_preview, parent, false)
        return MyViewHolder(itemView)
    }
    override fun onBindViewHolder(
        holder: MyViewHolder,
        @SuppressLint("RecyclerView") position: Int
    ) {
        val thumbnailItem: FilterItem = thumbnailItemList[position]
        thumbnailItem.imageUrl?.let {
            // TODO
        }
        holder.image.setOnClickListener {
            listener.onFilterSelected(thumbnailItem.filter, thumbnailItem.imageUrl.orEmpty())
            selectedIndex = position
            notifyDataSetChanged()
        }
        holder.filterName.text = thumbnailItem.filterName
        if (selectedIndex == position) {
            holder.filterName.setTextColor(
                ContextCompat.getColor(
                    holder.filterName.context,
                    androidx.cardview.R.color.cardview_dark_background
                )
            )
        } else {
            holder.filterName.setTextColor(
                ContextCompat.getColor(
                    holder.filterName.context,
                    androidx.cardview.R.color.cardview_dark_background
                )
            )
        }
    }
    override fun getItemCount(): Int {
        return thumbnailItemList.size
    }
    interface ThumbnailsAdapterListener {
        fun onFilterSelected(filter: MySuperFilter?, url: String)
    }
}