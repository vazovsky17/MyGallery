package app.vazovsky.mygallery.presentation.photo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import app.vazovsky.mygallery.data.model.Photo
import app.vazovsky.mygallery.data.remote.base.LoadableResult
import app.vazovsky.mygallery.domain.GetPhotoByIdUseCase
import app.vazovsky.mygallery.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PhotoViewModel @Inject constructor(
    private val getPhotoByIdUseCase: GetPhotoByIdUseCase,
) : BaseViewModel() {

    /** Фото */
    private val _photoLiveData = MutableLiveData<LoadableResult<Photo>>()
    val photoLiveData: LiveData<LoadableResult<Photo>> = _photoLiveData

    /** Получение фото по ID */
    fun getPhotoById(id: String) {
        _photoLiveData.launchLoadData(
            getPhotoByIdUseCase.executeFlow(GetPhotoByIdUseCase.Params(id))
        )
    }
}