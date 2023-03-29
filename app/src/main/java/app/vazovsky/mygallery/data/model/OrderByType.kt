package app.vazovsky.mygallery.data.model

import com.google.gson.annotations.SerializedName

/** Тип сортировки */
enum class OrderByType {
    @SerializedName("latest")
    LATEST,

    @SerializedName("oldest")
    OLDEST,

    @SerializedName("popular")
    POPULAR;
}