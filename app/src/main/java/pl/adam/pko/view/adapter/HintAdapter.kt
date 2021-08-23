package pl.adam.pko.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pl.adam.pko.R

class HintAdapter(
    private val hintsList: List<String>,
    private val onClickListener: (query: String) -> Unit
) :
    RecyclerView.Adapter<HintAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_hint, parent, false))

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.hintTV.text = hintsList[position]
        viewHolder.hintTV.setOnClickListener { onClickListener(hintsList[position]) }
    }

    override fun getItemCount() = hintsList.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val hintTV: TextView = view.findViewById(R.id.hintTV)
    }

}