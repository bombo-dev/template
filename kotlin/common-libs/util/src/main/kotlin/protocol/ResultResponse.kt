package protocol

import com.fasterxml.jackson.annotation.JsonFormat
import time.DateTimeUtils
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

data class ResultResponse<T>(
    val code: String,
    val message: String? = null,
    val errorDetails: List<String> = emptyList(),
    val data: T,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX", timezone = "Asia/Seoul")
    val serverDateTime: ZonedDateTime = DateTimeUtils.now()
) {
    companion object {
        const val CODE_SUCCEED = "SUCCEED"
        const val CODE_FAILED = "FAILED"

        fun <T> ok(data: T) = ResultResponse(
            code = CODE_SUCCEED,
            data = data,
        )

        fun ok() = ok(Unit)

        fun fail(message: String?) = ResultResponse(
            code = CODE_FAILED,
            message = message,
            data = Unit,
        )

        fun fail(code: String, message: String?) = ResultResponse(
            code = code,
            message = message,
            data = Unit,
        )

        fun fail(code: String, message: String?, errorDetails: List<String>) = ResultResponse(
            code = code,
            message = message,
            errorDetails = errorDetails,
            data = Unit,
        )

        fun <T> custom(
            code: String,
            data: T
        ) = ResultResponse(
            code = code,
            data = data,
        )
    }
}
