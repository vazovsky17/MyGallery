package app.vazovsky.mygallery.presentation.photo

import android.os.Bundle
import androidx.fragment.app.viewModels
import app.vazovsky.mygallery.R
import app.vazovsky.mygallery.databinding.FragmentPhotoBinding
import app.vazovsky.mygallery.presentation.base.BaseFragment
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PhotoFragment : BaseFragment(R.layout.fragment_photo) {

    private val binding by viewBinding(FragmentPhotoBinding::bind)
    private val viewModel: PhotoViewModel by viewModels()

    override fun callOperations() {

    }

    override fun onSetupLayout(savedInstanceState: Bundle?) = with(binding) {

    }

    override fun onBindViewModel() = with(viewModel) {
        observeNavigationCommands()
    }
}