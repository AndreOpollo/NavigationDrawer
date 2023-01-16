package com.example.navigationdrawer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawerLayout)
        toggle = ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val navView = findViewById<NavigationView>(R.id.navigationView)
        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.miItem1->Toast.makeText(applicationContext,
                    "Item 1 selected",Toast.LENGTH_SHORT).show()
                R.id.miItem2->Toast.makeText(applicationContext,
                    "Item 2 selected",Toast.LENGTH_SHORT).show()
                R.id.miItem3->Toast.makeText(applicationContext,
                    "Item 3 selected",Toast.LENGTH_SHORT).show()

            }
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
       if(toggle.onOptionsItemSelected(item)) {
           return true
       }
        return super.onOptionsItemSelected(item)
    }
}