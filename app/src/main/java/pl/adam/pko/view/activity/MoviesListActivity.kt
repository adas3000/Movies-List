package pl.adam.pko.view.activity

import org.kodein.di.instance
import pl.adam.pko.R
import pl.adam.pko.presenter.movies_list.IMoviesListPresenter
import pl.adam.pko.view.view.MoviesListView

class MoviesListActivity : BaseActivity<MoviesListView>(), MoviesListView {

    override val presenter by instance<IMoviesListPresenter>()

    override fun getLayoutRes() = R.layout.activity_main

    override fun setupView() {
        //        val retrofit = Retrofit.Builder()
//            .addConverterFactory(GsonConverterFactory.create())
//            .baseUrl(BuildConfig.SERVER_URL)
//            .client(OkHttpClient.Builder().addInterceptor {
//                var request = it.request()
//                val url = request.url.newBuilder().addQueryParameter("api_key", BuildConfig.API_KEY)
//                    .build()
//                request = request.newBuilder().url(url).build()
//                it.proceed(request)
//            }.build())
//            .build()
//        val service: ApiService = retrofit.create(ApiService::class.java)
//        Thread {
//            runBlocking {
//                val playingMovies = service.getPlayingNowMovies()
//                runOnUiThread {
//                    val moviesListAdapter = MovieAdapter(playingMovies.results.map {
//                        Movie(
//                            it.id,
//                            it.adult,
//                            it.backDropPath,
//                            it.overview,
//                            it.popularity,
//                            it.posterUrl,
//                            it.releaseDate,
//                            it.title,
//                            it.video,
//                            it.voteAverage,
//                            it.voteCount
//                        )
//                    })
//                    itemsRV.adapter = moviesListAdapter
//                }
//            }
//        }.start()
    }

    override fun getMvpView() = this
}