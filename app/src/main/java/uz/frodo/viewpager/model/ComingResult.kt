package uz.frodo.viewpager.model

data class ComingResult(
    val results: List<ResultX>,
    val total: Int,
    val total_pages: Int
)