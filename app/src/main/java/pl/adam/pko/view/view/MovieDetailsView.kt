package pl.adam.pko.view.view

import pl.adam.pko.model.model.Movie

interface MovieDetailsView : MvpView {
    fun passedMovie(): Movie
    fun showMovie(movie: Movie)
    fun setOnBackClickListener(onBackClickListener: () -> Unit)
    fun close()
}
