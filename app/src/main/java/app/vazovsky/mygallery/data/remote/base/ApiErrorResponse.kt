package app.vazovsky.mygallery.data.remote.base

import com.google.gson.annotations.SerializedName

/** Данные об ошибке запроса */
data class ApiErrorResponse(
    /** Ошибка */
    @SerializedName("error") val error: Data?,
) {

    data class Data(
        /** Код ошибки */
        @SerializedName("code") val code: String?,

        /** Сообщение об ошибке */
        @SerializedName("message") val message: String?,
    )

    fun toParsedError(): ParsedError {
        return ApiError(
            code = error?.code ?: DEFAULT_ERROR_CODE,
            message = error?.message ?: DEFAULT_ERROR_MESSAGE,
        )
    }
}