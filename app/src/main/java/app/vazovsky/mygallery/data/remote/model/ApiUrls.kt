package app.vazovsky.mygallery.data.remote.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
class ApiUrls(
    @SerializedName("raw") val raw: String?,
    @SerializedName("full") val full: String?,
    @SerializedName("regular") val regular: String?,
    @SerializedName("small") val small: String?,
    @SerializedName("thumb") val thumb: String?,
) : Parcelable