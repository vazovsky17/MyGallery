package app.vazovsky.mygallery.data.model

import app.vazovsky.mygallery.data.repository.GalleryRepository
import app.vazovsky.mygallery.domain.base.paging.BasePagingSource

class PhotoPagingSource(
    query: String?,
    private val galleryRepository: GalleryRepository,
) : BasePagingSource<Photo>(query) {
    override suspend fun loadPage(offset: Int, limit: Int, query: String?): List<Photo> {
        return galleryRepository.getPhotos(page = offset.toLong(), itemsOnPage = limit.toLong(), orderBy = query)
    }
}