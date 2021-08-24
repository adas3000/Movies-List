package pl.adam.pko.model.repository.movie

import android.util.Log
import pl.adam.pko.BuildConfig
import pl.adam.pko.model.model.Movie
import pl.adam.pko.model.network.response.HttpResult
import pl.adam.pko.model.network.service.ApiService

class MoviesListRepository(private val apiService: ApiService) : IMoviesListRepository {
    override suspend fun getNowPlayingMoviesList(page: Int): HttpResult<List<Movie>> {
        try {
            val data = apiService.getPlayingNowMovies(page = page).results.map {
                Movie(
                    id = it.id,
                    adult = it.adult,
                    backDropPath = "${BuildConfig.IMAGES_URL}${it.backDropPath}",
                    overview = it.overview,
                    popularity = it.popularity,
                    posterUrl = "${BuildConfig.IMAGES_URL}${it.posterUrl}",
                    releaseDate = it.releaseDate,
                    title = it.title,
                    video = it.video,
                    voteAverage = it.voteAverage,
                    voteCount = it.voteCount
                )
            }
            return HttpResult.Success(data)
        } catch (e: Throwable) {
            Log.e("Http", e.message.toString())
            return HttpResult.Failure(e)
        }
    }

    override suspend fun getQueryMovies(query: String, page: Int): HttpResult<List<Movie>> {
        try {
            val data = apiService.getQueryMovies(query, page).results.map {
                Movie(
                    id = it.id,
                    adult = it.adult,
                    backDropPath = "${BuildConfig.IMAGES_URL}${it.backDropPath}",
                    overview = it.overview,
                    popularity = it.popularity,
                    posterUrl = "${BuildConfig.IMAGES_URL}${it.posterUrl}",
                    releaseDate = it.releaseDate,
                    title = it.title,
                    video = it.video,
                    voteAverage = it.voteAverage,
                    voteCount = it.voteCount
                )
            }
            return HttpResult.Success(data)
        } catch (e: Throwable) {
            Log.e("Http", e.message.toString())
            return HttpResult.Failure(e)
        }
    }
}