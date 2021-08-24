package pl.adam.pko.model.interactor.movies_list

import pl.adam.pko.model.model.Movie
import pl.adam.pko.model.network.response.HttpResult
import pl.adam.pko.model.preferences.favorite_movies.IFavoriteMoviesPreferences
import pl.adam.pko.model.repository.movie.IMoviesListRepository

class MoviesListInteractor(
    private val moviesListRepository: IMoviesListRepository,
    private val favoritesMoviesPreferences: IFavoriteMoviesPreferences
) :
    IMoviesListInteractor {
    override suspend fun getNowPlayingMovies(page: Int): HttpResult<List<Movie>> {
        val data = moviesListRepository.getNowPlayingMoviesList(page)
        if (data is HttpResult.Success) {
            data.data.onEach { it.favorite = favoritesMoviesPreferences.isFavorite(it.id) }
        }
        return data
    }

    override fun saveMovieFavorite(id: Int, favorite: Boolean) {
        favoritesMoviesPreferences.setFavorite(id, favorite)
    }

    override suspend fun getQueryMovies(query: String, page: Int) =
        moviesListRepository.getQueryMovies(query, page)
}