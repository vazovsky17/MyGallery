package app.vazovsky.mygallery.presentation.gallery.tabs

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.vazovsky.mygallery.R
import app.vazovsky.mygallery.data.model.OrderByTab
import app.vazovsky.mygallery.databinding.ItemOrderByTabBinding
import app.vazovsky.mygallery.presentation.base.inflate
import by.kirich1409.viewbindingdelegate.viewBinding

class TabViewHolder(
    parent: ViewGroup,
    private val onItemClick: (OrderByTab) -> Unit,
) : RecyclerView.ViewHolder(parent.inflate(R.layout.item_order_by_tab)) {
    private val binding by viewBinding(ItemOrderByTabBinding::bind)

    fun bind(item: OrderByTab) = with(binding.root) {
        text = item.type.name
        isChecked = item.isSelected
        isCloseIconVisible = isChecked
        setOnClickListener {
            isChecked = item.isSelected
            onItemClick(item)
        }
    }
}