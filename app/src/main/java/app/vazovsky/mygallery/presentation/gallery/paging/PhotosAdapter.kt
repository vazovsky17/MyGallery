package app.vazovsky.mygallery.presentation.gallery.paging

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import app.vazovsky.mygallery.data.model.Photo
import app.vazovsky.mygallery.presentation.gallery.photos.PhotoViewHolder
import app.vazovsky.mygallery.managers.DiffUtilItemCallbackFactory
import javax.inject.Inject


class PhotosAdapter @Inject constructor(
    diffUtilItemCallbackFactory: DiffUtilItemCallbackFactory,
) : PagingDataAdapter<Photo, PhotoViewHolder>(diffUtilItemCallbackFactory.create()) {

    lateinit var onItemClick: (Photo) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        return PhotoViewHolder(parent, onItemClick)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }
}