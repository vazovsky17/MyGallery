package app.vazovsky.mygallery.presentation.gallery

import android.os.Bundle
import androidx.fragment.app.viewModels
import app.vazovsky.mygallery.R
import app.vazovsky.mygallery.databinding.FragmentGalleryBinding
import app.vazovsky.mygallery.presentation.base.BaseFragment
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GalleryFragment : BaseFragment(R.layout.fragment_gallery) {

    private val binding by viewBinding(FragmentGalleryBinding::bind)
    private val viewModel: GalleryViewModel by viewModels()

    override fun callOperations() {

    }

    override fun onSetupLayout(savedInstanceState: Bundle?) = with(binding) {
        buttonPhoto.setOnClickListener { viewModel.openPhoto() }
    }

    override fun onBindViewModel() = with(viewModel) {
        observeNavigationCommands()
    }
}