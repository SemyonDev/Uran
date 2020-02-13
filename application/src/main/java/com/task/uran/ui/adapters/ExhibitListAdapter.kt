package com.task.uran.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.task.model.entities.Exhibit
import com.task.uran.R
import kotlinx.android.synthetic.main.item_exhibitlist.view.*
import java.util.*

class ExhibitListAdapter : RecyclerView.Adapter<ExhibitListAdapter.ProductItemViewHolder>() {

    private var exhibitList: List<Exhibit> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductItemViewHolder {
        return ProductItemViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_exhibitlist, parent, false)
        )
    }

    override fun onBindViewHolder(viewHolder: ProductItemViewHolder, position: Int) {
        viewHolder.bind(exhibitList[position])
    }

    override fun getItemCount() = exhibitList.size

    fun setData(exhibitList: List<Exhibit>) {
        this.exhibitList = exhibitList
        notifyDataSetChanged()
    }

    class ProductItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(exhibit: Exhibit) = with(itemView) {
            item_productlist_rv.adapter = ExhibitItemAdapter(exhibit)
            item_productlist_rv.layoutManager =
                LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL, false)
        }
    }
}

