package pl.adam.pko.presenter.movies_list

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.kodein.di.instance
import pl.adam.pko.model.interactor.movies_list.IMoviesListInteractor
import pl.adam.pko.model.model.Movie
import pl.adam.pko.presenter.base.BasePresenter
import pl.adam.pko.view.view.MoviesListView

class MoviesListPresenter : BasePresenter<MoviesListView>(), IMoviesListPresenter {

    private val interactor by instance<IMoviesListInteractor>()

    override fun attachView(view: MoviesListView) {
        super.attachView(view)
        setActions()
        load()
    }

    private fun setActions() {
        view.setOnMovieImageClickListener { view.showMovieDetails(it) }
        view.setOnMovieStarClickListener { movie: Movie, index: Int ->
            movie.favorite = movie.favorite.not()
            interactor.saveMovieFavorite(
                id = movie.id,
                favorite = movie.favorite
            )
            view.refreshList(index)
        }
    }

    private fun load() {
        launch {
            val movies = interactor.getNowPlayingMovies()
            withContext(Dispatchers.Main) {
                view.showMovies(movies)
            }
        }
    }

}