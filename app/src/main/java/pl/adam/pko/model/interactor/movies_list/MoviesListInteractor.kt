package pl.adam.pko.model.interactor.movies_list

import pl.adam.pko.model.repository.movie.IMoviesListRepository

class MoviesListInteractor(private val moviesListRepository: IMoviesListRepository) :
    IMoviesListInteractor {
    override suspend fun getNowPlayingMovies(page: Int) =
        moviesListRepository.getNowPlayingMoviesList(page)
}