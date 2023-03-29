package app.vazovsky.mygallery.data.model

import android.os.Parcelable
import app.vazovsky.mygallery.managers.Similarable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Photo(
    val id: String,
    val description: String,
    val urls: Urls,
    val likes: Long,
) : Parcelable, Similarable<Photo> {
    override fun areItemsTheSame(other: Photo): Boolean {
        return this.id == other.id
    }

    override fun areContentsTheSame(other: Photo): Boolean {
        return this == other
    }
}