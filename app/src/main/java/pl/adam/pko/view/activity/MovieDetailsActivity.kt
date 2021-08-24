package pl.adam.pko.view.activity

import android.view.Menu
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_movie_details.*
import org.kodein.di.instance
import pl.adam.pko.R
import pl.adam.pko.model.model.Movie
import pl.adam.pko.presenter.movie_details.IMovieDetailsPresenter
import pl.adam.pko.view.view.MovieDetailsView


class MovieDetailsActivity : BaseActivity<MovieDetailsView>(), MovieDetailsView {

    companion object {
        const val MOVIE_KEY = "Movie"
    }

    lateinit var movie: Movie

    override val presenter by instance<IMovieDetailsPresenter>()

    override fun getLayoutRes() = R.layout.activity_movie_details

    private var onFavoriteClickListener = {}

    private var onBackClickListener = {}

    private var menu: Menu? = null

    override fun setupView() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        movie = Gson().fromJson(intent.extras?.getString(MOVIE_KEY), Movie::class.java)
    }

    override fun passedMovie() = movie

    override fun getMvpView() = this

    override fun showMovie(movie: Movie) {
        supportActionBar?.title = movie.title
        Glide.with(this).load(movie.posterUrl).into(imgIV)
        titleTV.text = movie.title
        releaseDateTV.text = "Premiera: ${movie.releaseDate}"
        overviewTV.text = movie.overview
        rateTV.text = "Ocena: ${movie.voteAverage}"
        menu?.getItem(0)?.setIcon(
            if (movie.favorite) {
                R.drawable.ic_favorite
            } else {
                R.drawable.ic_un_favorite
            }
        )
    }

    override fun setOnFavoriteClickListener(onFavoriteClickListener: () -> Unit) {
        this.onFavoriteClickListener = onFavoriteClickListener
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_movie_details, menu)
        this.menu = menu
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackClickListener()
                true
            }
            R.id.menu_favor_unfavor -> {
                onFavoriteClickListener()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun setOnBackClickListener(onBackClickListener: () -> Unit) {
        this.onBackClickListener = onBackClickListener
    }

    override fun close() {
        finish()
    }
}