package app.vazovsky.mygallery.presentation.gallery.photos

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.vazovsky.mygallery.R
import app.vazovsky.mygallery.data.model.Photo
import app.vazovsky.mygallery.databinding.ItemPhotoBinding
import app.vazovsky.mygallery.extensions.load
import app.vazovsky.mygallery.presentation.base.inflate
import by.kirich1409.viewbindingdelegate.viewBinding

class PhotoViewHolder(
    parent: ViewGroup,
    private val onItemClick: (Photo) -> Unit,
) : RecyclerView.ViewHolder(parent.inflate(R.layout.item_photo)) {
    private val binding by viewBinding(ItemPhotoBinding::bind)

    fun bind(item: Photo) = with(binding) {
        root.setOnClickListener { onItemClick(item) }
        imageViewPhoto.load(
            item.urls.full
        )
    }
}