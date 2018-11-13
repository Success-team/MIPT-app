package mipt.app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EventsAdapter(private val onClick : (String, String) -> Unit) : RecyclerView.Adapter<EventsViewHolder>() {

    private val arrayOfItems = arrayOf(
        "lorem",
        "ipsum",
        "dolor",
        "sitaaaa",
        "ametaaaa",
        "consectetuer"
    )


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return EventsViewHolder(inflater.inflate(R.layout.event_item, parent, false), ::onItemClick)
    }

    override fun getItemCount(): Int = arrayOfItems.size

    override fun onBindViewHolder(holder: EventsViewHolder, position: Int) {
        holder.setText(arrayOfItems[position])
        holder.setTitle(arrayOfItems[position].substring(0, 5).capitalize())
    }

    fun onItemClick(view: View, title: String, text: String) {
        onClick(title, text)
    }
}

class EventsViewHolder(view : View, private val clickListener : (View, String, String) -> Unit ) : RecyclerView.ViewHolder(view) {
    private val title: TextView = view.findViewById(R.id.title)
    private val text: TextView = view.findViewById(R.id.text)

    fun setText(text : String) {
        this.text.text = text
    }

    fun setTitle(title : String) {
        this.title.text = title
    }

    init {
        view.setOnClickListener {
            clickListener(it, title.toString(), text.toString())
        }
    }
}