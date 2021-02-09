package com.ramim94.androidtvkeyboard

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ramim94.tvkeyboard.callback.OnSearchButtonPressedListener
import com.ramim94.tvkeyboard.TvKeyboardView
import com.ramim94.tvkeyboard.callback.OnItemFocusChanged

class ExampleFragment : Fragment(), OnSearchButtonPressedListener, OnItemFocusChanged {

    lateinit var kbView: TvKeyboardView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_blank, container, false)
        kbView = view.findViewById(R.id.keyboard)
        kbView.addOnSearchButtonPressedListener(this)
        kbView.addOnItemFocusChangedListener(this)

        kbView.getSearchInputView().hint = "Search Video"
        return view
    }

    companion object {
        val TAG = ExampleFragment::class.java.simpleName
    }

    override fun onSearchButtonPressed(queryString: String) {
        Log.d(TAG, "onSearchButtonPressed: $queryString")
        //process input text as you wish.
    }

    override fun onItemFocusChanged(index: Int) {
        Log.d(TAG, "onItemFocusChanged: $index")
    }
}