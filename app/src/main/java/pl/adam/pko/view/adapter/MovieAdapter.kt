package pl.adam.pko.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import pl.adam.pko.BuildConfig
import pl.adam.pko.R
import pl.adam.pko.model.model.Movie

class MovieAdapter(private val movieList: List<Movie>, private val onClick: (movie: Movie) -> Unit) :
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false))

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.titleTV.text = movieList[position].title
        viewHolder.releaseDateTV.text = "Premiera: ${movieList[position].releaseDate}"
        Glide.with(viewHolder.itemView)
            .load(movieList[position].posterUrl)
            .into(viewHolder.imgIV)
        viewHolder.imgIV.setOnClickListener { onClick(movieList[position]) }
    }

    override fun getItemCount() = movieList.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleTV: TextView = view.findViewById(R.id.titleTV)
        val releaseDateTV: TextView = view.findViewById(R.id.releaseDateTV)
        val imgIV: ImageView = view.findViewById(R.id.imgIV)
    }

}