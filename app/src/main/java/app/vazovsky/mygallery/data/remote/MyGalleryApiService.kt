package app.vazovsky.mygallery.data.remote

import app.vazovsky.mygallery.data.remote.response.ApiPhotoData
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MyGalleryApiService {

    /**
     * Получение списка фото
     * @param page Номер страницы
     * @param perPage Количество фото на странице
     * @param orderBy Тип сортировки. По умолчанию "latest"
     */
    @GET("photos")
    suspend fun getPhotos(
        @Query("page") page: Long?,
        @Query("per_page") perPage: Long?,
        @Query("order_by") orderBy: String?,
    ): List<ApiPhotoData>

    /**
     * Получение фото по ID
     * @param id ID искомого фото
     */
    @GET("photos/{id}")
    suspend fun getPhotoById(
        @Path("id") id: String,
    ): ApiPhotoData

}