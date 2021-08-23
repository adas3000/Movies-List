package pl.adam.pko.model.preferences.favorite_movies

import pl.adam.pko.model.preferences.Preferences

interface IFavoriteMoviesPreferences : Preferences {
    fun setFavorite(id: Int, favorite: Boolean)
    fun isFavorite(id: Int): Boolean
}