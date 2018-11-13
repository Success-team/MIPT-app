package mipt.app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import android.widget.Toast

class CalendarFragment : Fragment() {

    private lateinit var router : Router

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        router = Router(requireActivity(), R.id.events_container)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val layout = inflater.inflate(R.layout.fragment_calendar, container, false)
        val calendar : CalendarView = layout.findViewById(R.id.calendar)
        calendar.setOnDateChangeListener {view, year, month, dayOfMonth ->
            changedDate(year, month, dayOfMonth)
        }

        return layout
    }

    private fun changedDate(year: Int, month : Int, dayOfMonth : Int) {
        val msg = "Selected date is " + dayOfMonth + "/" + (month + 1) + "/" + year
        Toast.makeText(requireActivity(), msg, Toast.LENGTH_SHORT).show()
        router.navigateTo(false, ::EventsListFragment)
    }
}