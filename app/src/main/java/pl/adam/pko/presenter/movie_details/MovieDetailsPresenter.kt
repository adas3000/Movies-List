package pl.adam.pko.presenter.movie_details

import org.kodein.di.instance
import pl.adam.pko.model.interactor.movie_details.IMovieDetailsInteractor
import pl.adam.pko.presenter.base.BasePresenter
import pl.adam.pko.view.view.MovieDetailsView

class MovieDetailsPresenter : BasePresenter<MovieDetailsView>(), IMovieDetailsPresenter {

    private val interactor by instance<IMovieDetailsInteractor>()

    override fun attachView(view: MovieDetailsView) {
        super.attachView(view)
        view.setOnBackClickListener { view.close() }
        view.setOnFavoriteClickListener {
            val movie = view.passedMovie()
            movie.favorite = movie.favorite.not()
            interactor.saveMovieFavorite(
                id = movie.id,
                favorite = movie.favorite
            )
            view.showMovie(movie)
        }
        view.showMovie(view.passedMovie())
    }

}