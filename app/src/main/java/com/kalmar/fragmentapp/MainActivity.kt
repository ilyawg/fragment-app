package com.kalmar.fragmentapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

private const val LAST_SELECTED_ITEM = "item"

class MainActivity : AppCompatActivity() {
    private lateinit var bottomMenu: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomMenu = findViewById(R.id.bottom_navigation_view)
        bottomMenu.setOnItemSelectedListener { item ->
            replaceFragment(item.itemId)
            true
        }
        bottomMenu.selectedItemId = savedInstanceState?.getInt(LAST_SELECTED_ITEM) ?: R.id.menu
    }

    private fun replaceFragment(id: Int) {
        val nextFragment = when (id) {
            R.id.menu -> MenuFragment()
            R.id.license -> LicenseFragment()
            else -> null
        }
        if (nextFragment != null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, nextFragment)
                .commit()

        } else
            Log.e("ERR_MSG", "replaceFragment: unknown id")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(LAST_SELECTED_ITEM, bottomMenu.selectedItemId)
        super.onSaveInstanceState(outState)
    }
}