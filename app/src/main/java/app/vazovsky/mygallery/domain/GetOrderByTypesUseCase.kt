package app.vazovsky.mygallery.domain

import app.vazovsky.mygallery.data.model.OrderByType
import app.vazovsky.mygallery.domain.base.usecase.UseCase
import app.vazovsky.mygallery.domain.base.usecase.UseCaseUnary
import javax.inject.Inject

class GetOrderByTypesUseCase @Inject constructor() : UseCaseUnary<UseCase.None, List<OrderByType>>() {

    override suspend fun execute(params: UseCase.None): List<OrderByType> {
        return OrderByType.values().toList()
    }
}