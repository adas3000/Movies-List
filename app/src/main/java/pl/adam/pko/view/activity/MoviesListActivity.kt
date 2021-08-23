package pl.adam.pko.view.activity

import android.content.Intent
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_movies_list.*
import org.kodein.di.instance
import pl.adam.pko.R
import pl.adam.pko.model.model.Movie
import pl.adam.pko.presenter.movies_list.IMoviesListPresenter
import pl.adam.pko.view.adapter.MovieAdapter
import pl.adam.pko.view.view.MoviesListView

class MoviesListActivity : BaseActivity<MoviesListView>(), MoviesListView {

    override val presenter by instance<IMoviesListPresenter>()

    override fun getLayoutRes() = R.layout.activity_movies_list

    override fun setupView() = Unit

    override fun getMvpView() = this

    private var onMovieClickListener = { _: Movie -> }

    override fun showMovies(movies: List<Movie>) {
        itemsRV.adapter = MovieAdapter(movies) { onMovieClickListener(it) }
    }

    override fun setOnMovieClickListener(onMovieClickListener: (movie: Movie) -> Unit) {
        this.onMovieClickListener = onMovieClickListener
    }

    override fun showMovieDetails(movie: Movie) {
        startActivity(Intent(this, MovieDetailsActivity::class.java).apply {
            putExtra(MovieDetailsActivity.MOVIE_KEY, Gson().toJson(movie))
        })
    }
}