package app.vazovsky.mygallery.presentation.gallery.tabs

import android.view.ViewGroup
import app.vazovsky.mygallery.data.model.OrderByTab
import app.vazovsky.mygallery.presentation.views.recyclerview.BaseAdapter
import javax.inject.Inject

class TabsAdapter @Inject constructor() : BaseAdapter<OrderByTab, TabViewHolder>() {

    lateinit var onItemClick: (OrderByTab) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TabViewHolder {
        return TabViewHolder(parent, onItemClick)
    }

    override fun onBindViewHolder(holder: TabViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}