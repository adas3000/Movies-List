package pl.adam.pko

import android.app.Application
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.bind
import org.kodein.di.singleton
import pl.adam.pko.model.interactor.movies_list.IMoviesListInteractor
import pl.adam.pko.model.interactor.movies_list.MoviesListInteractor
import pl.adam.pko.presenter.movies_list.IMoviesListPresenter
import pl.adam.pko.presenter.movies_list.MoviesListPresenter

class App : Application(), DIAware {

    companion object {
        lateinit var instance: App
            private set
    }

    override val di by DI.lazy {
        import(androidXModule(this@App))
        bind<IMoviesListPresenter>() with singleton { MoviesListPresenter() }
        bind<IMoviesListInteractor>() with singleton { MoviesListInteractor() }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

}