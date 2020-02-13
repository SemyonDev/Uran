package com.task.uran.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.request.RequestOptions
import com.task.model.entities.Exhibit
import com.task.uran.R
import com.task.uran.di.GlideApp
import kotlinx.android.synthetic.main.item_exhibit.view.*

class ExhibitItemAdapter(private val exhibit:Exhibit) : RecyclerView.Adapter<ExhibitItemAdapter.ProductItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductItemViewHolder {
        return ProductItemViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_exhibit, parent, false)
        )
    }

    override fun onBindViewHolder(viewHolder: ProductItemViewHolder, position: Int) {
        viewHolder.bind(exhibit.images[position], exhibit.title)
    }

    override fun getItemCount() = exhibit.images.size

    class ProductItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(image: String, title:String) = with(itemView) {
            item_product_title.text = title
            GlideApp.with(this)
                .load(image)
                .apply(
                    RequestOptions()
                    .placeholder(R.drawable.ic_broken_image_white)
                )
                .into(item_product_img)
        }
    }
}

