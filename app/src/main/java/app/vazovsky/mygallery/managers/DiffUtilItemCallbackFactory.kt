package app.vazovsky.mygallery.managers

import androidx.recyclerview.widget.DiffUtil
import javax.inject.Inject

class DiffUtilItemCallbackFactory @Inject constructor() {

    fun <T : Similarable<T>> create(): DiffUtil.ItemCallback<T> {
        return object : DiffUtil.ItemCallback<T>() {
            override fun areItemsTheSame(oldItem: T, newItem: T) = oldItem.areItemsTheSame(newItem)
            override fun areContentsTheSame(oldItem: T, newItem: T) = oldItem.areContentsTheSame(newItem)
        }
    }
}