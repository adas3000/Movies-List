package pl.adam.pko.view.activity

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

    override fun setupView() {
        movie = Gson().fromJson(intent.extras?.getString(MOVIE_KEY), Movie::class.java)
    }

    override fun passedMovie() = movie

    override fun getMvpView() = this

    override fun showMovie(movie: Movie) {
        actionBar?.title = movie.title
        Glide.with(this).load(movie.posterUrl).into(imgIV)
        titleTV.text = movie.title
        releaseDateTV.text = "Premiera: ${movie.releaseDate}"
        overviewTV.text = movie.overview
        rateTV.text = "Ocena: ${movie.voteAverage}"
    }
}