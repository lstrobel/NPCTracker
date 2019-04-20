package edu.uw.npctracker

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/*
 * @author lstrobel
 */
class CharacterAdapter(private val characterDataset: Array<String>) :
    RecyclerView.Adapter<CharacterAdapter.MyViewHolder>() {

    // Provide a reference to the ViewHolder for each data item
    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view)

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        // create a new view
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.character_row, parent, false)
        // optional: set view parameters below
        return MyViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val text = holder.itemView.findViewById(R.id.character_item) as TextView
        text.text = characterDataset[position]
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = characterDataset.size
}
