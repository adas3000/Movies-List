package pl.adam.pko.model.network.service

import pl.adam.pko.model.network.response.NowPlayingResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("authentication/guest_session/new")
    suspend fun createGuestSession()

    @GET("movie/now_playing")
    suspend fun getPlayingNowMovies(
        @Query("language") language: String = "en-US",
        @Query("page") page: Int = 1
    ): NowPlayingResponse
}