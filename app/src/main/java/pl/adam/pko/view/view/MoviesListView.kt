package pl.adam.pko.view.view

import pl.adam.pko.model.model.Movie

interface MoviesListView : MvpView {
    fun showMovies(movies: List<Movie>)
    fun setOnMovieImageClickListener(onMovieImageClickListener: (movie: Movie) -> Unit)
    fun setOnMovieStarClickListener(onMovieStarClickListener: (movie: Movie, index: Int) -> Unit)
    fun setOnSearchQueryChanged(onSearchQueryChanged: (query: String) -> Unit)
    fun setOnSearchQueryClickListener(onSearchQueryClickListener: (query: String) -> Unit)
    fun showMovieDetails(movie: Movie)
    fun showHints(hintsList: List<String>)
    fun refreshList(index: Int)
    fun setQueryListVisibility(visible: Boolean)
    fun setSearchQueryText(text: String)
}