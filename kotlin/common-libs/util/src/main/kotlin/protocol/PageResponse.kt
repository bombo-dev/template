package protocol

data class PageResponse<T>(
    val number: Int,
    val size: Int,
    val totalPages: Int,
    val totalElements: Long,
    val content: List<T>,
) {
    companion object {
        fun <T> of(number: Int, size: Int, totalPages: Int, totalElements: Long, content: List<T>): PageResponse<T> {
            return PageResponse(
                number = number + 1,
                size = size,
                totalPages = totalPages,
                totalElements = totalElements,
                content = content
            )
        }
    }
}
