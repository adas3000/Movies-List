package pl.adam.pko.presenter.movies_list

import org.kodein.di.instance
import pl.adam.pko.model.interactor.movies_list.IMoviesListInteractor
import pl.adam.pko.presenter.base.BasePresenter
import pl.adam.pko.view.view.MoviesListView

class MoviesListPresenter : BasePresenter<MoviesListView>(), IMoviesListPresenter {

    private val interactor by instance<IMoviesListInteractor>()

    override fun attachView(view: MoviesListView) {
        super.attachView(view)
    }

}