package app.vazovsky.mygallery.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Photo(
    val id: String,
    val description: String,
    val urls: Urls,
    val likes: Long,
) : Parcelable