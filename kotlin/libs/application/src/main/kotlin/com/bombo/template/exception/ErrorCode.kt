package com.bombo.template.exception

enum class ErrorCode(
    val code: String,
    val message: String,
) {
    COM_000("COM_000", "정의되지 않은 에러코드 입니다.")
}
