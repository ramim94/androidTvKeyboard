package com.ramim94.tvkeyboard

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class SpaceItemDecor : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        outRect.left = 0
        outRect.right = 0
        outRect.bottom = 0
        outRect.top = 0
    }
}