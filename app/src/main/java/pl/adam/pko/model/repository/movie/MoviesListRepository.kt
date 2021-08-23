package pl.adam.pko.model.repository.movie

import pl.adam.pko.model.model.Movie
import pl.adam.pko.model.network.service.ApiService

class MoviesListRepository(private val apiService: ApiService) : IMoviesListRepository {
    override suspend fun getNowPlayingMoviesList(page: Int) =
        apiService.getPlayingNowMovies(page = page).results.map {
            Movie(
                id = it.id,
                adult = it.adult,
                backDropPath = it.backDropPath,
                overview = it.overview,
                popularity = it.popularity,
                posterUrl = it.posterUrl,
                releaseDate = it.releaseDate,
                title = it.title,
                video = it.video,
                voteAverage = it.voteAverage,
                voteCount = it.voteCount
            )
        }
}