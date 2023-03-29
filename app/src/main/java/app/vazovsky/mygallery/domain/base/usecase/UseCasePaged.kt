package app.vazovsky.mygallery.domain.base.usecase

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

abstract class UseCasePaged<in Params, Result> : UseCase where Result : Any {

    abstract fun execute(params: Params): Flow<PagingData<Result>>

    fun executeFlow(params: Params): Flow<PagingData<Result>> {
        return execute(params)
    }
}