package mipt.app

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var router  : Router
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.mipt_toolbar))

        router = Router(this, R.id.events_container)
        if (savedInstanceState == null) router.navigateTo(false, ::EventsListFragment)
    }

    override fun onBackPressed() {
        if (!router.navigateBack()) {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_item, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_calendar -> {
            router.navigateTo(true, ::CalendarFragment)
            true
        }

        else -> {
            super.onOptionsItemSelected(item)
        }
    }
}