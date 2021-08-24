package pl.adam.pko.model.interactor.movie_details

import pl.adam.pko.model.interactor.Interactor

interface IMovieDetailsInteractor : Interactor {
    fun saveMovieFavorite(id: Int, favorite: Boolean)
}