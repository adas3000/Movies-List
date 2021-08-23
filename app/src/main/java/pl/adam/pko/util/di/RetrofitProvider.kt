package pl.adam.pko.util.di

import okhttp3.OkHttpClient
import pl.adam.pko.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitProvider {

    private val okHttpClient = OkHttpClient.Builder().addInterceptor {
        var request = it.request()
        val url =
            request.url.newBuilder().addQueryParameter("api_key", BuildConfig.API_KEY).build()
        request = request.newBuilder().url(url).build()
        it.proceed(request)
    }.build()

    val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BuildConfig.SERVER_URL)
        .client(okHttpClient)
        .build()
}