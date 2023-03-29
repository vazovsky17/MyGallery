package app.vazovsky.mygallery.data.remote.response

import android.os.Parcelable
import app.vazovsky.mygallery.data.remote.model.ApiUrls
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
class ApiPhotoData(
    @SerializedName("id") val id: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("urls") val urls: ApiUrls?,
    @SerializedName("likes") val likes: Long?,
) : Parcelable