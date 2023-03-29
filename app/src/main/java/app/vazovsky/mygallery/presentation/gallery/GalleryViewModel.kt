package app.vazovsky.mygallery.presentation.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import app.vazovsky.mygallery.data.model.OrderByTab
import app.vazovsky.mygallery.data.model.OrderByType
import app.vazovsky.mygallery.data.model.Photo
import app.vazovsky.mygallery.data.remote.base.LoadableResult
import app.vazovsky.mygallery.domain.GetOrderByTypesUseCase
import app.vazovsky.mygallery.domain.GetPhotosUseCase
import app.vazovsky.mygallery.domain.base.UseCase
import app.vazovsky.mygallery.extensions.also
import app.vazovsky.mygallery.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GalleryViewModel @Inject constructor(
    private val destinations: GalleryDestinations,
    private val getOrderByTypesUseCase: GetOrderByTypesUseCase,
    private val getPhotosUseCase: GetPhotosUseCase,
) : BaseViewModel() {

    /** Табы для сортировки */
    private val _orderByTypesLiveData = MutableLiveData<LoadableResult<List<OrderByType>>>()
    val orderByTypesLiveData: LiveData<LoadableResult<List<OrderByType>>> = _orderByTypesLiveData.also { result ->
        result.doOnSuccess { types ->
            _tabsLiveData.postValue(types.map { type ->
                OrderByTab(type = type, isSelected = false)
            })
        }
    }

    /** Табы для сортировки */
    private val _tabsLiveData = MutableLiveData<List<OrderByTab>>()
    val tabsLiveData: LiveData<List<OrderByTab>> = _tabsLiveData.also { tabs ->
        val selectedTab = tabs.firstOrNull { it.isSelected }
        getPhotos(orderByType = selectedTab?.type)
    }

    /** Список фото */
    private val _photosLiveData = MutableLiveData<LoadableResult<List<Photo>>>()
    val photosLiveData: LiveData<LoadableResult<List<Photo>>> = _photosLiveData

    /** Получение табов */
    fun getTypes() {
        _orderByTypesLiveData.launchLoadData(
            getOrderByTypesUseCase.executeFlow(UseCase.None)
        )
    }


    /**
     * Получение списка фото
     * @param page Номер страницы
     * @param itemsOnPage Количество фото на странице
     * @param orderByType Тип сортировки
     */
    fun getPhotos(page: Long? = null, itemsOnPage: Long? = null, orderByType: OrderByType? = null) {
        _photosLiveData.launchLoadData(
            getPhotosUseCase.executeFlow(GetPhotosUseCase.Params(page, itemsOnPage, orderByType)),
        )
    }

    fun updateTabs(tab: OrderByTab) {
        val newList = _tabsLiveData.value?.map {
            it.copy(isSelected = tab.type == it.type)
        }
        newList?.let { _tabsLiveData.postValue(it) }
    }

    fun openPhoto(id: String) {
        navigate(destinations.photo(id))
    }
}