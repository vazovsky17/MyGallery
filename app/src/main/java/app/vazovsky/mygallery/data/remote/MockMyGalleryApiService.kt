package app.vazovsky.mygallery.data.remote

import app.vazovsky.mygallery.data.remote.model.ApiUrls
import app.vazovsky.mygallery.data.remote.response.ApiPhotoData
import kotlinx.coroutines.delay

class MockMyGalleryApiService : MyGalleryApiService {

    private val photos = listOf(
        ApiPhotoData(
            id = "lolkek1",
            description = "Lol kek chebureck",
            urls = ApiUrls(
                raw = "https://images.unsplash.com/photo-1679678691026-ed4f5361c7aa?crop=entropy&cs=srgb&fm=jpg&ixid=" +
                        "Mnw0Mjg0NTh8MXwxfGFsbHwxfHx8fHx8fHwxNjgwMDE1NTg3&ixlib=rb-4.0.3&q=85",
                full = "https://images.unsplash.com/photo-1679678691026-ed4f5361c7aa?crop=entropy&cs=srgb&fm=jpg&ixid=" +
                        "Mnw0Mjg0NTh8MXwxfGFsbHwxfHx8fHx8fHwxNjgwMDE1NTg3&ixlib=rb-4.0.3&q=85",
                regular = "https://images.unsplash.com/photo-1679678691026-ed4f5361c7aa?crop=entropy&cs=srgb&fm=jpg&ixid=" +
                        "Mnw0Mjg0NTh8MXwxfGFsbHwxfHx8fHx8fHwxNjgwMDE1NTg3&ixlib=rb-4.0.3&q=85",
                small = "https://images.unsplash.com/photo-1679678691026-ed4f5361c7aa?crop=entropy&cs=srgb&fm=jpg&ixid=" +
                        "Mnw0Mjg0NTh8MXwxfGFsbHwxfHx8fHx8fHwxNjgwMDE1NTg3&ixlib=rb-4.0.3&q=85",
                thumb = "https://images.unsplash.com/photo-1679678691026-ed4f5361c7aa?crop=entropy&cs=srgb&fm=jpg&ixid=" +
                        "Mnw0Mjg0NTh8MXwxfGFsbHwxfHx8fHx8fHwxNjgwMDE1NTg3&ixlib=rb-4.0.3&q=85",
            ),
            likes = 12,
        ),
        ApiPhotoData(
            id = "lolkek2",
            description = "Lol kek chebureck",
            urls = ApiUrls(
                raw = "https://images.unsplash.com/photo-1679678691026-ed4f5361c7aa?crop=entropy&cs=srgb&fm=jpg&ixid=" +
                        "Mnw0Mjg0NTh8MXwxfGFsbHwxfHx8fHx8fHwxNjgwMDE1NTg3&ixlib=rb-4.0.3&q=85",
                full = "https://images.unsplash.com/photo-1679678691026-ed4f5361c7aa?crop=entropy&cs=srgb&fm=jpg&ixid=" +
                        "Mnw0Mjg0NTh8MXwxfGFsbHwxfHx8fHx8fHwxNjgwMDE1NTg3&ixlib=rb-4.0.3&q=85",
                regular = "https://images.unsplash.com/photo-1679678691026-ed4f5361c7aa?crop=entropy&cs=srgb&fm=jpg&ixid=" +
                        "Mnw0Mjg0NTh8MXwxfGFsbHwxfHx8fHx8fHwxNjgwMDE1NTg3&ixlib=rb-4.0.3&q=85",
                small = "https://images.unsplash.com/photo-1679678691026-ed4f5361c7aa?crop=entropy&cs=srgb&fm=jpg&ixid=" +
                        "Mnw0Mjg0NTh8MXwxfGFsbHwxfHx8fHx8fHwxNjgwMDE1NTg3&ixlib=rb-4.0.3&q=85",
                thumb = "https://images.unsplash.com/photo-1679678691026-ed4f5361c7aa?crop=entropy&cs=srgb&fm=jpg&ixid=" +
                        "Mnw0Mjg0NTh8MXwxfGFsbHwxfHx8fHx8fHwxNjgwMDE1NTg3&ixlib=rb-4.0.3&q=85",
            ),
            likes = 12,
        ),
        ApiPhotoData(
            id = "lolkek3",
            description = "Lol kek chebureck",
            urls = ApiUrls(
                raw = "https://images.unsplash.com/photo-1679678691026-ed4f5361c7aa?crop=entropy&cs=srgb&fm=jpg&ixid=" +
                        "Mnw0Mjg0NTh8MXwxfGFsbHwxfHx8fHx8fHwxNjgwMDE1NTg3&ixlib=rb-4.0.3&q=85",
                full = "https://images.unsplash.com/photo-1679678691026-ed4f5361c7aa?crop=entropy&cs=srgb&fm=jpg&ixid=" +
                        "Mnw0Mjg0NTh8MXwxfGFsbHwxfHx8fHx8fHwxNjgwMDE1NTg3&ixlib=rb-4.0.3&q=85",
                regular = "https://images.unsplash.com/photo-1679678691026-ed4f5361c7aa?crop=entropy&cs=srgb&fm=jpg&ixid=" +
                        "Mnw0Mjg0NTh8MXwxfGFsbHwxfHx8fHx8fHwxNjgwMDE1NTg3&ixlib=rb-4.0.3&q=85",
                small = "https://images.unsplash.com/photo-1679678691026-ed4f5361c7aa?crop=entropy&cs=srgb&fm=jpg&ixid=" +
                        "Mnw0Mjg0NTh8MXwxfGFsbHwxfHx8fHx8fHwxNjgwMDE1NTg3&ixlib=rb-4.0.3&q=85",
                thumb = "https://images.unsplash.com/photo-1679678691026-ed4f5361c7aa?crop=entropy&cs=srgb&fm=jpg&ixid=" +
                        "Mnw0Mjg0NTh8MXwxfGFsbHwxfHx8fHx8fHwxNjgwMDE1NTg3&ixlib=rb-4.0.3&q=85",
            ),
            likes = 12,
        ),
        ApiPhotoData(
            id = "lolkek4",
            description = "Lol kek chebureck",
            urls = ApiUrls(
                raw = "https://images.unsplash.com/photo-1679678691026-ed4f5361c7aa?crop=entropy&cs=srgb&fm=jpg&ixid=" +
                        "Mnw0Mjg0NTh8MXwxfGFsbHwxfHx8fHx8fHwxNjgwMDE1NTg3&ixlib=rb-4.0.3&q=85",
                full = "https://images.unsplash.com/photo-1679678691026-ed4f5361c7aa?crop=entropy&cs=srgb&fm=jpg&ixid=" +
                        "Mnw0Mjg0NTh8MXwxfGFsbHwxfHx8fHx8fHwxNjgwMDE1NTg3&ixlib=rb-4.0.3&q=85",
                regular = "https://images.unsplash.com/photo-1679678691026-ed4f5361c7aa?crop=entropy&cs=srgb&fm=jpg&ixid=" +
                        "Mnw0Mjg0NTh8MXwxfGFsbHwxfHx8fHx8fHwxNjgwMDE1NTg3&ixlib=rb-4.0.3&q=85",
                small = "https://images.unsplash.com/photo-1679678691026-ed4f5361c7aa?crop=entropy&cs=srgb&fm=jpg&ixid=" +
                        "Mnw0Mjg0NTh8MXwxfGFsbHwxfHx8fHx8fHwxNjgwMDE1NTg3&ixlib=rb-4.0.3&q=85",
                thumb = "https://images.unsplash.com/photo-1679678691026-ed4f5361c7aa?crop=entropy&cs=srgb&fm=jpg&ixid=" +
                        "Mnw0Mjg0NTh8MXwxfGFsbHwxfHx8fHx8fHwxNjgwMDE1NTg3&ixlib=rb-4.0.3&q=85",
            ),
            likes = 12,
        ),
    )

    override suspend fun getPhotos(page: Long?, perPage: Long?, orderBy: String?): List<ApiPhotoData> {
        delay(1000L)
        return photos
    }

    override suspend fun getPhotoById(id: String): ApiPhotoData {
        delay(1000L)
        return photos.first { photo -> photo.id == id }
    }
}