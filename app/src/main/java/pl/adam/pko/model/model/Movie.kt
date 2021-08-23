package pl.adam.pko.model.model

data class Movie(
    val id: Int,
    val adult: Boolean,
    val backDropPath: String,
    val overview: String,
    val popularity: Double,
    val posterUrl: String,
    val releaseDate: String,
    val title: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Int
)
