package pl.adam.pko.util.di

import android.util.Log
import okhttp3.OkHttpClient
import pl.adam.pko.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.nio.Buffer

object RetrofitProvider {

    private val okHttpClient = OkHttpClient.Builder().addInterceptor {
        var request = it.request()
//        Log.i("HTTP", "Request:${request.body.writeTo(Buffer())}")
        val url = request.url.newBuilder().addQueryParameter("api_key", BuildConfig.API_KEY).build()
        request = request.newBuilder().url(url).build()
        val response = it.proceed(request)
//        Log.i("HTTP", "Response:${response.networkResponse}")
        response
    }.build()

    val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BuildConfig.SERVER_URL)
        .client(okHttpClient)
        .build()
}