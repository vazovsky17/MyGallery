package app.vazovsky.mygallery.data.remote

class SemimockMyGalleryApiService(
    private val apiService: MyGalleryApiService,
    private val mockApiService: MockMyGalleryApiService,
) : MyGalleryApiService {

}