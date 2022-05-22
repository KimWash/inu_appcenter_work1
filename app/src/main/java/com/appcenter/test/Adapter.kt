package com.appcenter.test

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView


class Adapter( var data:ArrayList<Person>) :
    RecyclerView.Adapter<Adapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView? = view.findViewById(R.id.name)
        val age: TextView? = view.findViewById(R.id.age)
        val part: TextView? = view.findViewById(R.id.part)
        val card:CardView? = view.findViewById(R.id.card)
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        return ViewHolder( LayoutInflater.from(viewGroup.context).inflate(R.layout.item, viewGroup, false) )
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.name!!.text = data[position].name
        viewHolder.age!!.text = data[position].age
        viewHolder.part!!.text = data[position].part
        setClick(viewHolder)
        setLongClick(viewHolder, position)

    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = data.size // 바로 리턴

    private fun setClick(holder:ViewHolder) {
        holder.card!!.setOnClickListener {
            val intent = Intent(holder.card!!.context, DetailActivity::class.java).apply {
                putExtra("name", holder.name!!.text)
                it.context.startActivity(this)
            }
        }
    }

    private fun setLongClick(holder:ViewHolder, position: Int) {
        holder.card!!.setOnLongClickListener {
            CustomDialog("항목을 제거하시겠습니까?", {
                data.removeAt(position)
                notifyItemRemoved(position)
                notifyItemRangeChanged(position, data.size)
            }, {}).show(holder.card.context)
            true
        }
    }

}
