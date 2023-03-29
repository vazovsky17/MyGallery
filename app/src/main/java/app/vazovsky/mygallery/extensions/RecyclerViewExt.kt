package app.vazovsky.mygallery.extensions

import androidx.annotation.DimenRes
import androidx.recyclerview.widget.RecyclerView
import app.vazovsky.mygallery.R
import app.vazovsky.mygallery.presentation.views.recyclerview.GridSpaceItemDecoration
import app.vazovsky.mygallery.presentation.views.recyclerview.LinearSpaceItemDecoration

/** Добавление декоратора для RecyclerView c LinearLayoutManager */
fun RecyclerView.addLinearSpaceItemDecoration(
    @DimenRes spacing: Int = R.dimen.padding_4,
    showFirstVerticalDivider: Boolean = false,
    showLastVerticalDivider: Boolean = false,
    showFirstHorizontalDivider: Boolean = false,
    showLastHorizontalDivider: Boolean = false,
    conditionProvider: LinearSpaceItemDecoration.ConditionProvider? = null,
) {
    this.addItemDecoration(
        LinearSpaceItemDecoration(
            context.resources.getDimensionPixelSize(spacing),
            showFirstVerticalDivider,
            showLastVerticalDivider,
            showFirstHorizontalDivider,
            showLastHorizontalDivider,
            conditionProvider,
        )
    )
}

/** Добавление декоратора для RecyclerView c GridLayoutManager */
fun RecyclerView.addDefaultGridSpaceItemDecoration(
    spanCount: Int,
    @DimenRes spacing: Int = R.dimen.padding_8,
    includeEdge: Boolean = false,
    excludeTopEdge: Boolean = true
) {
    val itemDecoration = GridSpaceItemDecoration(
        spanCount,
        context.resources.getDimensionPixelSize(spacing),
        includeEdge,
        excludeTopEdge,
    )
    this.addItemDecoration(itemDecoration)
}