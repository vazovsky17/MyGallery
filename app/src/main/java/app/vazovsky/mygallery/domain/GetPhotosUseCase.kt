package app.vazovsky.mygallery.domain

import androidx.paging.PagingData
import app.vazovsky.mygallery.data.model.OrderByType
import app.vazovsky.mygallery.data.model.Photo
import app.vazovsky.mygallery.data.repository.GalleryRepository
import app.vazovsky.mygallery.domain.base.paging.createPager
import app.vazovsky.mygallery.domain.base.usecase.UseCasePaged
import app.vazovsky.mygallery.data.model.PhotoPagingSource
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

/** Получение списка фото */
class GetPhotosUseCase @Inject constructor(
    private val galleryRepository: GalleryRepository,
) : UseCasePaged<GetPhotosUseCase.Params, Photo>() {

    override fun execute(params: Params): Flow<PagingData<Photo>> {
        return createPager(
            pagingSource = PhotoPagingSource(
                query = params.orderByType?.name?.lowercase(),
                galleryRepository = galleryRepository,
            )
        ).flow
    }

    data class Params(
        val orderByType: OrderByType?,
    )
}