package pl.adam.pko.model.interactor.movies_list

import pl.adam.pko.model.interactor.Interactor
import pl.adam.pko.model.model.Movie

interface IMoviesListInteractor : Interactor {
    suspend fun getNowPlayingMovies(page: Int = 1): List<Movie>
    fun saveMovieFavorite(id: Int, favorite: Boolean)
}