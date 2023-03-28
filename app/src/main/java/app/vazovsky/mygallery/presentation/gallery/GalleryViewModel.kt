package app.vazovsky.mygallery.presentation.gallery

import app.vazovsky.mygallery.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GalleryViewModel @Inject constructor(
    private val destinations: GalleryDestinations,
) : BaseViewModel() {

    fun openPhoto() {
        navigate(destinations.photo())
    }
}