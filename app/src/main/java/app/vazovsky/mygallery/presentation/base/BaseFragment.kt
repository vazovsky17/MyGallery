package app.vazovsky.mygallery.presentation.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.lifecycleScope
import app.vazovsky.mygallery.extensions.observeNavigationCommands

/** Базовый класс для фрагментов */
abstract class BaseFragment(@LayoutRes layout: Int) : Fragment(layout) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launchWhenStarted {
            callOperations()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onSetupLayout(savedInstanceState)
        onBindViewModel()
    }

    /** Для методов ViewModel, вызываемых при создании фрагмента */
    abstract fun callOperations()

    /** Для настройки UI */
    abstract fun onSetupLayout(savedInstanceState: Bundle?)

    /** Для подписки на LiveData */
    abstract fun onBindViewModel()

    fun BaseViewModel.observeNavigationCommands() {
        observeNavigationCommands(this)
    }

    protected infix fun <T> LiveData<T>.observe(block: (T) -> Unit) {
        observe(this@BaseFragment.viewLifecycleOwner) { t -> block.invoke(t) }
    }

}