package pl.adam.pko.model.repository

import pl.adam.pko.model.model.Movie

interface IMovieRepository : Repository {
    suspend fun getNowPlayingMoviesList(page: Int): List<Movie>
}