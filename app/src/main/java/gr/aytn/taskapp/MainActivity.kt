package gr.aytn.taskapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var names : ArrayList<String> = arrayListOf("UltraBoost19","Clear Shampoo","FairPrice Clementi","Supersonic","iPad Pro Cover")
        var dates : ArrayList<String> = arrayListOf("Sun, 5 Jan","Sat, 4 Jan","Fri, 3 Jan","Thu, 2 Jan","Wed, 1 Jan")
        var amounts : ArrayList<Int> = arrayListOf(25345,25452,5788,987,3242)



        val recyclerview = findViewById<RecyclerView>(R.id.recycler_view)

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this)

        // ArrayList of class ItemsViewModel
        val data = ArrayList<Item>()

        // This loop will create 20 Views containing
        // the image with the count of view
        for (i in 0..4) {
            data.add(Item(R.drawable.icon, names[i],dates[i],amounts[i]))
        }

        // This will pass the ArrayList to our Adapter
        val adapter = CustomAdapter(data)

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter




        val bottomNavigationView : BottomNavigationView = findViewById(R.id.bottom_navigation)

        bottomNavigationView.selectedItemId = R.id.home

        bottomNavigationView.setOnNavigationItemSelectedListener OnNavigationItemSelectedListener@{ item->
            when (item.itemId) {
                R.id.profile -> {
                    startActivity(Intent(this, ProfileActivity::class.java))
                    overridePendingTransition(0, 0)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.home-> return@OnNavigationItemSelectedListener true

                R.id.settings -> {
                    startActivity(Intent(this, SettingsActivity::class.java))
                    overridePendingTransition(0, 0)
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

    }
}