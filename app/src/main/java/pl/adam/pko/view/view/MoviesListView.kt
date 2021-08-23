package pl.adam.pko.view.view

import pl.adam.pko.model.model.Movie

interface MoviesListView : MvpView {
    fun showMovies(movies: List<Movie>)
    fun setOnMovieImageClickListener(onMovieImageClickListener: (movie: Movie) -> Unit)
    fun setOnMovieStarClickListener(onMovieStarClickListener: (movie: Movie, index: Int) -> Unit)
    fun showMovieDetails(movie: Movie)
    fun refreshList(index: Int)
}