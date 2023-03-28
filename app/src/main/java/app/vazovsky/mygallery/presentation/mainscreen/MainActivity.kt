package app.vazovsky.mygallery.presentation.mainscreen

import android.os.Bundle
import androidx.activity.viewModels
import app.vazovsky.mygallery.R
import app.vazovsky.mygallery.databinding.ActivityMainBinding
import app.vazovsky.mygallery.extensions.observeNavigationCommands
import app.vazovsky.mygallery.presentation.base.BaseActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private val binding by viewBinding(ActivityMainBinding::bind)
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onBindViewModel() = with(viewModel) {
        observeNavigationCommands(this, R.id.navHostFragment)
    }
}