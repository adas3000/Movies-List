package pl.adam.pko.model.interactor.movies_list

import pl.adam.pko.model.interactor.Interactor
import pl.adam.pko.model.model.Movie
import pl.adam.pko.model.network.response.HttpResult

interface IMoviesListInteractor : Interactor {
    suspend fun getNowPlayingMovies(page: Int = 1): HttpResult<List<Movie>>
    suspend fun getQueryMovies(query: String, page: Int): HttpResult<List<Movie>>
    fun saveMovieFavorite(id: Int, favorite: Boolean)
}