package app.vazovsky.mygallery.extensions

import androidx.lifecycle.LiveData
import androidx.lifecycle.map

/**
 * Аналог also для LiveData
 */
fun <T> LiveData<T>.also(block: (T) -> Unit): LiveData<T> {
    return map {
        block.invoke(it)
        it
    }
}