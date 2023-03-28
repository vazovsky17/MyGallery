package app.vazovsky.mygallery.presentation.base

import android.content.Intent
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions

/** Классы для навигации в приложении */
sealed class NavigationCommand {

    data class To(val directions: NavDirections, val navOptions: NavOptions? = null) : NavigationCommand()

    data class Activity(val intent: Intent) : NavigationCommand()

    object Back : NavigationCommand()

}