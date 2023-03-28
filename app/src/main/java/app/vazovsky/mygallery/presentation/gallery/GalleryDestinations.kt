package app.vazovsky.mygallery.presentation.gallery

import app.vazovsky.mygallery.presentation.base.NavigationCommand
import javax.inject.Inject

class GalleryDestinations @Inject constructor() {
    fun photo() = NavigationCommand.To(
        GalleryFragmentDirections.actionGalleryFragmentToPhotoFragment()
    )
}