package app.vazovsky.mygallery.presentation.gallery.photos

import android.view.ViewGroup
import app.vazovsky.mygallery.data.model.Photo
import app.vazovsky.mygallery.presentation.views.recyclerview.BaseAdapter
import javax.inject.Inject

class PhotosAdapter @Inject constructor() : BaseAdapter<Photo, PhotoViewHolder>() {

    lateinit var onItemClick: (Photo) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        return PhotoViewHolder(parent, onItemClick)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}