package pl.adam.pko.view.activity

import android.content.Intent
import android.view.View
import androidx.appcompat.widget.SearchView
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_movies_list.*
import org.kodein.di.instance
import pl.adam.pko.R
import pl.adam.pko.model.model.Movie
import pl.adam.pko.presenter.movies_list.IMoviesListPresenter
import pl.adam.pko.view.adapter.HintAdapter
import pl.adam.pko.view.adapter.MovieAdapter
import pl.adam.pko.view.view.MoviesListView

class MoviesListActivity : BaseActivity<MoviesListView>(), MoviesListView {

    override val presenter by instance<IMoviesListPresenter>()

    override fun getLayoutRes() = R.layout.activity_movies_list

    override fun setupView() {
        searchSV.setOnCloseListener {
            setQueryListVisibility(visible = false)
            false
        }
    }

    override fun getMvpView() = this

    private var onMovieImageClickListener = { _: Movie -> }

    private var onMovieStarClickListener = { _: Movie, _: Int -> }

    private var onSearchQueryClickListener = { _: String -> }

    override fun showMovies(movies: List<Movie>) {
        itemsRV.adapter =
            MovieAdapter(
                movies,
                { onMovieImageClickListener(it) },
                { movie: Movie, index: Int -> onMovieStarClickListener(movie, index) })
    }

    override fun setSearchQueryText(text: String) {
        searchSV.setQuery(text, true)
    }

    override fun showHints(hintsList: List<String>) {
        hintsRV.adapter = HintAdapter(hintsList) { onSearchQueryClickListener(it) }
    }

    override fun setQueryListVisibility(visible: Boolean) {
        hintsRV.visibility = if (visible) {
            View.VISIBLE
        } else {
            View.GONE
        }
    }

    override fun setOnSearchQueryChanged(onSearchQueryChanged: (query: String) -> Unit) {
        searchSV.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                onSearchQueryChanged(query ?: "")
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                onSearchQueryChanged(newText ?: "")
                return true
            }
        })
    }

    override fun setOnSearchQueryClickListener(onSearchQueryClickListener: (query: String) -> Unit) {
        this.onSearchQueryClickListener = onSearchQueryClickListener
    }

    override fun setOnMovieStarClickListener(onMovieStarClickListener: (movie: Movie, index: Int) -> Unit) {
        this.onMovieStarClickListener = onMovieStarClickListener
    }

    override fun setOnMovieImageClickListener(onMovieImageClickListener: (movie: Movie) -> Unit) {
        this.onMovieImageClickListener = onMovieImageClickListener
    }

    override fun showMovieDetails(movie: Movie) {
        startActivity(Intent(this, MovieDetailsActivity::class.java).apply {
            putExtra(MovieDetailsActivity.MOVIE_KEY, Gson().toJson(movie))
        })
    }

    override fun refreshList(index: Int) {
        itemsRV.adapter?.notifyItemChanged(index)
    }
}