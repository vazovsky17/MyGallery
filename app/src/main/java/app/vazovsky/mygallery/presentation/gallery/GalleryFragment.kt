package app.vazovsky.mygallery.presentation.gallery

import android.os.Bundle
import androidx.fragment.app.viewModels
import app.vazovsky.mygallery.R
import app.vazovsky.mygallery.databinding.FragmentGalleryBinding
import app.vazovsky.mygallery.domain.base.paging.PagingLoadStateAdapter
import app.vazovsky.mygallery.extensions.addDefaultGridSpaceItemDecoration
import app.vazovsky.mygallery.extensions.addLinearSpaceItemDecoration
import app.vazovsky.mygallery.extensions.fitTopInsetsWithPadding
import app.vazovsky.mygallery.presentation.base.BaseFragment
import app.vazovsky.mygallery.presentation.gallery.paging.PhotosAdapter
import app.vazovsky.mygallery.presentation.gallery.tabs.TabsAdapter
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import timber.log.Timber

@AndroidEntryPoint
class GalleryFragment : BaseFragment(R.layout.fragment_gallery) {

    private val binding by viewBinding(FragmentGalleryBinding::bind)
    private val viewModel: GalleryViewModel by viewModels()

    @Inject lateinit var photosAdapter: PhotosAdapter
    @Inject lateinit var tabsAdapter: TabsAdapter

    override fun callOperations() {
        viewModel.getTypes()
    }

    override fun onSetupLayout(savedInstanceState: Bundle?) = with(binding) {
        root.fitTopInsetsWithPadding()

        stateViewFlipper.setRetryMethod { viewModel.getTypes() }
        setupRecyclerView()
    }

    override fun onBindViewModel() = with(viewModel) {
        observeNavigationCommands()
        pagingDataLiveData.observe { padingData ->
            photosAdapter.submitData(lifecycle, padingData)
        }
        pagingStateLiveData.observe { result ->
            binding.stateViewFlipper.setStateFromResult(result)
        }
//        photosLiveData.observe { result ->
//            binding.stateViewFlipper.setStateFromResult(result)
//            result.doOnSuccess { gallery ->
//                photosAdapter.submitList(gallery)
//            }
//            result.doOnFailure { Timber.d(it.message) }
//        }
        orderByTypesLiveData.observe { result ->
            result.doOnFailure { Timber.d(it.message) }
        }
        tabsLiveData.observe { tabs -> tabsAdapter.submitList(tabs) }
    }

    private fun setupRecyclerView() = with(binding) {
        photosAdapter.apply {
            onItemClick = { photo -> viewModel.openPhoto(photo.id) }
            addLoadStateListener { loadState -> viewModel.bindPagingState(loadState) }
        }
        recyclerViewPhotos.adapter = photosAdapter.withLoadStateFooter(
            footer = PagingLoadStateAdapter { photosAdapter.retry() }
        )
        recyclerViewPhotos.addDefaultGridSpaceItemDecoration(
            spanCount = 2,
            spacing = R.dimen.padding_12,
            includeEdge = true,
        )

        recyclerViewOrderBy.adapter = tabsAdapter.apply {
            onItemClick = { tab ->
                val newTab = tab.copy(isSelected = !tab.isSelected)
                viewModel.updateTabs(newTab)
            }
        }
        recyclerViewOrderBy.addLinearSpaceItemDecoration(
            spacing = R.dimen.padding_12,
            showFirstVerticalDivider = true,
            showLastVerticalDivider = true,
        )
    }
}