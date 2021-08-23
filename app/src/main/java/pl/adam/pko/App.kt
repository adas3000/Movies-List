package pl.adam.pko

import android.app.Application
import org.kodein.di.*
import org.kodein.di.android.x.androidXModule
import pl.adam.pko.model.interactor.movies_list.IMoviesListInteractor
import pl.adam.pko.model.interactor.movies_list.MoviesListInteractor
import pl.adam.pko.model.network.service.ApiService
import pl.adam.pko.model.repository.movie.IMoviesListRepository
import pl.adam.pko.model.repository.movie.MoviesListRepository
import pl.adam.pko.presenter.movies_list.IMoviesListPresenter
import pl.adam.pko.presenter.movies_list.MoviesListPresenter
import pl.adam.pko.util.di.RetrofitProvider
import retrofit2.Retrofit

class App : Application(), DIAware {

    companion object {
        lateinit var instance: App
            private set
    }

    override val di by DI.lazy {
        import(androidXModule(this@App))
        bind<ApiService>() with singleton { RetrofitProvider.retrofit.create(ApiService::class.java) }
        bind<IMoviesListPresenter>() with singleton { MoviesListPresenter() }
        bind<IMoviesListRepository>() with singleton { MoviesListRepository(instance()) }
        bind<IMoviesListInteractor>() with singleton { MoviesListInteractor(instance()) }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

}