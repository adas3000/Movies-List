package pl.adam.pko.view.view

import pl.adam.pko.model.model.Movie

interface MoviesListView : MvpView {
    fun showMovies(movies: List<Movie>)
}