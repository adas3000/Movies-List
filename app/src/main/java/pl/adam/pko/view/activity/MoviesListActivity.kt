package pl.adam.pko.view.activity

import kotlinx.android.synthetic.main.activity_movies_list.*
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import org.kodein.di.instance
import pl.adam.pko.BuildConfig
import pl.adam.pko.R
import pl.adam.pko.model.model.Movie
import pl.adam.pko.model.network.service.ApiService
import pl.adam.pko.presenter.movies_list.IMoviesListPresenter
import pl.adam.pko.view.adapter.MovieAdapter
import pl.adam.pko.view.view.MoviesListView
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MoviesListActivity : BaseActivity<MoviesListView>(), MoviesListView {

    override val presenter by instance<IMoviesListPresenter>()

    override fun getLayoutRes() = R.layout.activity_movies_list

    override fun setupView() = Unit

    override fun getMvpView() = this

    override fun showMovies(movies: List<Movie>) {
        itemsRV.adapter = MovieAdapter(movies)
    }
}