package pl.adam.pko.model.repository.movie

import pl.adam.pko.model.model.Movie
import pl.adam.pko.model.network.response.HttpResult
import pl.adam.pko.model.repository.Repository

interface IMoviesListRepository : Repository {
    suspend fun getNowPlayingMoviesList(page: Int): HttpResult<List<Movie>>
    suspend fun getQueryMovies(query: String, page: Int): HttpResult<List<Movie>>
}