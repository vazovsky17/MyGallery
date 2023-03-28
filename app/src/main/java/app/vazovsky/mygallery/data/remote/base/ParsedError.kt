package app.vazovsky.mygallery.data.remote.base

import com.google.gson.annotations.SerializedName

sealed class ParsedError(
    @SerializedName("code") val code: String,
    @SerializedName("message") val message: String,
)

class NetworkError(code: String, message: String) : ParsedError(code, message)
class GeneralError(code: String, message: String) : ParsedError(code, message)
class ApiError(code: String, message: String) : ParsedError(code, message)

var DEFAULT_ERROR_MESSAGE: String = "KinopoiskDev"
const val DEFAULT_ERROR_CODE = "TEXT_ERROR"