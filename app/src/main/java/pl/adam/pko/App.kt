package pl.adam.pko

import android.app.Application
import android.content.Context
import org.kodein.di.*
import org.kodein.di.android.x.androidXModule
import pl.adam.pko.model.interactor.movie_details.IMovieDetailsInteractor
import pl.adam.pko.model.interactor.movie_details.MovieDetailsInteractor
import pl.adam.pko.model.interactor.movies_list.IMoviesListInteractor
import pl.adam.pko.model.interactor.movies_list.MoviesListInteractor
import pl.adam.pko.model.network.service.ApiService
import pl.adam.pko.model.preferences.favorite_movies.FavoriteMoviesPreferences
import pl.adam.pko.model.preferences.favorite_movies.IFavoriteMoviesPreferences
import pl.adam.pko.model.repository.movie.IMoviesListRepository
import pl.adam.pko.model.repository.movie.MoviesListRepository
import pl.adam.pko.presenter.movie_details.IMovieDetailsPresenter
import pl.adam.pko.presenter.movie_details.MovieDetailsPresenter
import pl.adam.pko.presenter.movies_list.IMoviesListPresenter
import pl.adam.pko.presenter.movies_list.MoviesListPresenter
import pl.adam.pko.util.di.RetrofitProvider

class App : Application(), DIAware {

    companion object {
        lateinit var instance: App
            private set
    }

    override val di by DI.lazy {
        import(androidXModule(this@App))
        bind<ApiService>() with singleton { RetrofitProvider.retrofit.create(ApiService::class.java) }
        bind<IFavoriteMoviesPreferences>() with singleton {
            FavoriteMoviesPreferences(
                getSharedPreferences("Prefs", Context.MODE_PRIVATE)
            )
        }
        bind<IMoviesListRepository>() with singleton { MoviesListRepository(instance()) }
        bind<IMovieDetailsInteractor>() with singleton { MovieDetailsInteractor(instance()) }
        bind<IMoviesListInteractor>() with singleton {
            MoviesListInteractor(
                instance(),
                instance()
            )
        }
        bind<IMovieDetailsPresenter>() with singleton { MovieDetailsPresenter() }
        bind<IMoviesListPresenter>() with singleton { MoviesListPresenter() }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

}