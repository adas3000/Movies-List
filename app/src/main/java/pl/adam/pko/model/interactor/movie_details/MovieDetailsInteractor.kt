package pl.adam.pko.model.interactor.movie_details

import pl.adam.pko.model.preferences.favorite_movies.IFavoriteMoviesPreferences

class MovieDetailsInteractor(
    private val favoritesMoviesPreferences: IFavoriteMoviesPreferences
) : IMovieDetailsInteractor {
    override fun saveMovieFavorite(id: Int, favorite: Boolean) {
        favoritesMoviesPreferences.setFavorite(id, favorite)
    }
}