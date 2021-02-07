package com.ramim94.androidtvkeyboard

import android.os.Bundle
import androidx.fragment.app.FragmentActivity

class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment = ExampleFragment()
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_browse_fragment, fragment)
                .commitAllowingStateLoss()
    }
}