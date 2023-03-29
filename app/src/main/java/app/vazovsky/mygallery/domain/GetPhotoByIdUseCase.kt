package app.vazovsky.mygallery.domain

import app.vazovsky.mygallery.data.model.Photo
import app.vazovsky.mygallery.data.repository.GalleryRepository
import app.vazovsky.mygallery.domain.base.usecase.UseCaseUnary
import javax.inject.Inject

/** Получение фото по ID */
class GetPhotoByIdUseCase @Inject constructor(
    private val galleryRepository: GalleryRepository,
) : UseCaseUnary<GetPhotoByIdUseCase.Params, Photo>() {

    override suspend fun execute(params: Params): Photo {
        return galleryRepository.getPhotoById(params.id)
    }

    data class Params(
        val id: String,
    )
}