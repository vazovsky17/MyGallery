package app.vazovsky.mygallery.domain

import app.vazovsky.mygallery.data.model.OrderByType
import app.vazovsky.mygallery.data.model.Photo
import app.vazovsky.mygallery.data.repository.GalleryRepository
import app.vazovsky.mygallery.domain.base.UseCaseUnary
import javax.inject.Inject

/** Получение списка фото */
class GetPhotosUseCase @Inject constructor(
    private val galleryRepository: GalleryRepository,
) : UseCaseUnary<GetPhotosUseCase.Params, List<Photo>>() {

    override suspend fun execute(params: Params): List<Photo> {
        return galleryRepository.getPhotos(
            page = params.page,
            itemsOnPage = params.itemsOnPage,
            orderBy = params.orderByType?.name?.lowercase(),
        )
    }

    data class Params(
        val page: Long?,
        val itemsOnPage: Long?,
        val orderByType: OrderByType?,
    )
}