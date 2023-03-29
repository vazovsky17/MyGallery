package app.vazovsky.mygallery.data.repository

import app.vazovsky.mygallery.data.model.Photo

interface GalleryRepository {

    suspend fun getPhotos(page: Long? = 1, itemsOnPage: Long? = 20, orderBy: String? = null): List<Photo>

    suspend fun getPhotoById(id: String): Photo
}