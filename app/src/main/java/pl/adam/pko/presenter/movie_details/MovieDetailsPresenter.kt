package pl.adam.pko.presenter.movie_details

import pl.adam.pko.presenter.base.BasePresenter
import pl.adam.pko.view.view.MovieDetailsView

class MovieDetailsPresenter : BasePresenter<MovieDetailsView>(), IMovieDetailsPresenter {

    override fun attachView(view: MovieDetailsView) {
        super.attachView(view)
        view.showMovie(view.passedMovie())
    }

}