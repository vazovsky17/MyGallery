package app.vazovsky.mygallery.data.remote

import app.vazovsky.mygallery.data.remote.response.ApiPhotoData

class SemimockMyGalleryApiService(
    private val apiService: MyGalleryApiService,
    private val mockApiService: MockMyGalleryApiService,
) : MyGalleryApiService {
    override suspend fun getPhotos(page: Long?, perPage: Long?, orderBy: String?): List<ApiPhotoData> {
        return apiService.getPhotos(page, perPage, orderBy)
    }

    override suspend fun getPhotoById(id: String): ApiPhotoData {
        return apiService.getPhotoById(id)
    }
}