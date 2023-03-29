package app.vazovsky.mygallery.data.repository

import app.vazovsky.mygallery.data.mapper.GalleryMapper
import app.vazovsky.mygallery.data.model.OrderByType
import app.vazovsky.mygallery.data.model.Photo
import app.vazovsky.mygallery.data.remote.MyGalleryApiService
import javax.inject.Inject

class GalleryRepositoryImpl @Inject constructor(
    private val apiService: MyGalleryApiService,
    private val galleryMapper: GalleryMapper,
) : GalleryRepository {

    override suspend fun getPhotos(page: Long?, itemsOnPage: Long?, orderBy: String?): List<Photo> {
        return apiService.getPhotos(
            page = page,
            perPage = itemsOnPage,
            orderBy = orderBy,
        ).map { galleryMapper.fromApiToModel(it) }
    }

    override suspend fun getPhotoById(id: String): Photo {
        return galleryMapper.fromApiToModel(apiService.getPhotoById(id))
    }
}