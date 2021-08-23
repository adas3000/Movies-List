package pl.adam.pko.model.preferences.favorite_movies

import android.content.SharedPreferences

class FavoriteMoviesPreferences(private val sharedPreferences: SharedPreferences) :
    IFavoriteMoviesPreferences {

    companion object {
        private const val KEY = "FavoriteMoviesKey"
    }

    override fun setFavorite(id: Int, favorite: Boolean) {
        val ids = sharedPreferences.getString(KEY, "123,123")?.split(",")?.map { it.toInt() }?.toMutableList()
        if (ids?.contains(id) == true && favorite.not()) {
            ids.remove(id)
        } else if (ids?.contains(id) == false && favorite) {
            ids.add(id)
        }
        sharedPreferences.edit().putString(KEY, ids?.joinToString(",")).apply()
    }

    override fun isFavorite(id: Int): Boolean {
        val ids =
            sharedPreferences.getString(KEY, "123,123")?.split(",")?.toTypedArray()?.map { it.toInt() }
                ?.toMutableList()
        return ids?.contains(id) == true
    }
}