package mipt.app

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    lateinit var router  : Router
    lateinit var mDrawerLayout : DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.mipt_toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp)
        mDrawerLayout = findViewById(R.id.drawer_layout)


        router = Router(this, R.id.events_container)
        if (savedInstanceState == null) router.navigateTo(false, ::EventsListFragment)

        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener { menuItem ->
            // set item as selected to persist highlight
            menuItem.isChecked = true
            when (menuItem.itemId) {
                0 -> router.navigateTo(true, ::EventsListFragment)
                1 -> router.navigateTo(true, ::EventsListFragment)
            }
            mDrawerLayout.closeDrawer(GravityCompat.START)

            true
        }



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

        R.id.home -> {
            val dl : DrawerLayout = findViewById(R.id.drawer_layout)
            dl.openDrawer(GravityCompat.START)
            true
        }

        else -> {
            super.onOptionsItemSelected(item)
        }
    }
}