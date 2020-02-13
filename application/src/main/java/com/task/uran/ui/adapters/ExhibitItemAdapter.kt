package com.task.uran.ui.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.task.model.entities.Exhibit
import com.task.uran.R
import com.task.uran.inflate
import com.task.uran.load
import kotlinx.android.synthetic.main.item_exhibit.view.*

class ExhibitItemAdapter(private val exhibit:Exhibit) : RecyclerView.Adapter<ExhibitItemAdapter.ProductItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductItemViewHolder {
        return ProductItemViewHolder(
            parent inflate R.layout.item_exhibit
        )
    }

    override fun onBindViewHolder(viewHolder: ProductItemViewHolder, position: Int) {
        viewHolder.bind(exhibit.images[position], exhibit.title)
    }

    override fun getItemCount() = exhibit.images.size

    class ProductItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(image: String, title:String) = with(itemView) {
            item_product_title.text = title
            item_product_img load image
        }
    }
}

