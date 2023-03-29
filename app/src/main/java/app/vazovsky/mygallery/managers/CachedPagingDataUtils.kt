package app.vazovsky.mygallery.managers

import androidx.paging.PagingData
import androidx.paging.cachedIn
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

@Singleton
class CachedPagingDataUtils @Inject constructor() {
    fun <T : Any> cacheIn(pagingFlow: Flow<PagingData<T>>, scope: CoroutineScope) = pagingFlow.cachedIn(scope)
}
