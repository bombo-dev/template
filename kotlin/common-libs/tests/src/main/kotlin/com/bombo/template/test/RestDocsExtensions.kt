package com.bombo.template.test

import org.springframework.restdocs.operation.preprocess.OperationRequestPreprocessor
import org.springframework.restdocs.operation.preprocess.OperationResponsePreprocessor
import org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessRequest
import org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse
import org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint
import org.springframework.restdocs.payload.JsonFieldType
import org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath
import org.springframework.restdocs.payload.PayloadDocumentation.subsectionWithPath
import org.springframework.restdocs.request.RequestDocumentation.parameterWithName

fun defaultPreprocessRequest(): OperationRequestPreprocessor {
    return preprocessRequest(
        prettyPrint()
    )
}

fun defaultPreprocessResponse(): OperationResponsePreprocessor {
    return preprocessResponse(
        prettyPrint()
    )
}

fun pageableRequestParameters() = arrayOf(
    parameterWithName("page").optional().description("페이지 번호 (0..n)"),
    parameterWithName("size").optional().description("페이지 크기"),
)

fun defaultResponseFields() = arrayOf(
    fieldWithPath("code")
        .type(JsonFieldType.STRING)
        .description("응답코드"),
    fieldWithPath("message")
        .type(JsonFieldType.STRING)
        .optional()
        .description("응답메시지"),
    subsectionWithPath("data")
        .description(""),
    fieldWithPath("errorDetails")
        .type(JsonFieldType.ARRAY)
        .description("에러 상세 정보"),
    fieldWithPath("serverDateTime")
        .type(JsonFieldType.STRING)
        .description("서버 응답 시간")
)

fun pageableResponseFields() = arrayOf(
    fieldWithPath("data.totalPages")
        .type(JsonFieldType.NUMBER)
        .description("총 페이지 수"),
    fieldWithPath("data.totalElements")
        .type(JsonFieldType.NUMBER)
        .description("총 아이템 수"),
    fieldWithPath("data.number")
        .type(JsonFieldType.NUMBER)
        .description("현재 페이지 (0..n)"),
    fieldWithPath("data.size")
        .type(JsonFieldType.NUMBER)
        .description("페이지 크기"),
)
