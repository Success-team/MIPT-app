package mipt.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class EventsListFragment: Fragment() {

    private lateinit var router: Router

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        router = Router(requireActivity(), R.id.events_container)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val layout = inflater.inflate(R.layout.fragment_eventslist, container, false)
        val recycler: RecyclerView = layout.findViewById(R.id.events_list)
        recycler.setHasFixedSize(true)
        createSimpleList(recycler)

        return layout
    }

    private fun createSimpleList(recycler: RecyclerView) {
        recycler.layoutManager = LinearLayoutManager(
            requireContext(),
            RecyclerView.VERTICAL,
            false
        )
        recycler.adapter = EventsAdapter(::onEventsClick)
    }

    private fun onEventsClick(title: String, text: String) {
        router.navigateTo(true, ::EventFragment)
    }
}