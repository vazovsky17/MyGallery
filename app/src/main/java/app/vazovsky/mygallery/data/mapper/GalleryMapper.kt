package app.vazovsky.mygallery.data.mapper

import app.vazovsky.mygallery.data.model.Photo
import app.vazovsky.mygallery.data.model.Urls
import app.vazovsky.mygallery.data.remote.model.ApiUrls
import app.vazovsky.mygallery.data.remote.response.ApiPhotoData
import app.vazovsky.mygallery.extensions.orDefault
import javax.inject.Inject

class GalleryMapper @Inject constructor() {

    fun fromApiToModel(apiModel: ApiPhotoData?): Photo {
        return Photo(
            id = apiModel?.id.orDefault(),
            description = apiModel?.description.orDefault(),
            urls = fromApiToModel(apiModel?.urls),
            likes = apiModel?.likes.orDefault(),
        )
    }

    private fun fromApiToModel(apiModel: ApiUrls?): Urls {
        return Urls(
            raw = apiModel?.raw.orDefault(),
            full = apiModel?.full.orDefault(),
            regular = apiModel?.regular.orDefault(),
            small = apiModel?.small.orDefault(),
            thumb = apiModel?.thumb.orDefault(),
        )
    }
}