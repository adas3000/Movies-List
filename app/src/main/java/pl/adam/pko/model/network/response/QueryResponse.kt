package pl.adam.pko.model.network.response

import com.google.gson.annotations.SerializedName

data class QueryResponse(
    val page: Int,
    val results: List<MovieResponse>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)
