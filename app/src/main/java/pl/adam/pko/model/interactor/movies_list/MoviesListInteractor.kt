package pl.adam.pko.model.interactor.movies_list

import pl.adam.pko.model.preferences.favorite_movies.IFavoriteMoviesPreferences
import pl.adam.pko.model.repository.movie.IMoviesListRepository

class MoviesListInteractor(
    private val moviesListRepository: IMoviesListRepository,
    private val favoritesMoviesPreferences: IFavoriteMoviesPreferences
) :
    IMoviesListInteractor {
    override suspend fun getNowPlayingMovies(page: Int) =
        moviesListRepository.getNowPlayingMoviesList(page).onEach { it.favorite = favoritesMoviesPreferences.isFavorite(it.id) }

    override fun saveMovieFavorite(id: Int, favorite: Boolean) {
        favoritesMoviesPreferences.setFavorite(id, favorite)
    }
}