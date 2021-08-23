package pl.adam.pko.model.network.response

data class NowPlayingResponse(
    val dates: Dates,
    val page: Int,
    val results: List<MovieResponse>
) {
    data class Dates(val maximum: String, val minimum: String)
}