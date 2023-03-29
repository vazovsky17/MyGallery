package app.vazovsky.mygallery.presentation.photo

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import app.vazovsky.mygallery.R
import app.vazovsky.mygallery.data.model.Photo
import app.vazovsky.mygallery.databinding.FragmentPhotoBinding
import app.vazovsky.mygallery.extensions.fitTopInsetsWithPadding
import app.vazovsky.mygallery.extensions.load
import app.vazovsky.mygallery.presentation.base.BaseFragment
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class PhotoFragment : BaseFragment(R.layout.fragment_photo) {

    private val binding by viewBinding(FragmentPhotoBinding::bind)
    private val viewModel: PhotoViewModel by viewModels()
    private val args by navArgs<PhotoFragmentArgs>()

    override fun callOperations() {
        args.id?.let { viewModel.getPhotoById(it) }
    }

    override fun onSetupLayout(savedInstanceState: Bundle?): Unit = with(binding) {
        root.fitTopInsetsWithPadding()

        buttonBack.setOnClickListener { viewModel.navigateBack() }
        stateViewFlipper.setRetryMethod { args.id?.let { viewModel.getPhotoById(it) } }
    }

    override fun onBindViewModel() = with(viewModel) {
        observeNavigationCommands()
        photoLiveData.observe { result ->
            binding.stateViewFlipper.setStateFromResult(result)
            result.doOnSuccess { photo -> bindPhoto(photo) }
            result.doOnFailure { Timber.d(it.message) }
        }
    }

    private fun bindPhoto(photo: Photo) = with(binding) {
        imageViewPhoto.load(photo.urls.full)
    }
}