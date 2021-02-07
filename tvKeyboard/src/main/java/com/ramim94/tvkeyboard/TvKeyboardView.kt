package com.ramim94.tvkeyboard


import android.content.Context
import android.util.AttributeSet
import android.widget.EditText
import android.widget.RelativeLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

/*
*
* init {
        val inflater = LayoutInflater.from(context)
        inflater.inflate(R.layout.tv_keyboard_view, this)
    }
* */

class TvKeyboardView : RelativeLayout ,KbInterface{
    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    private val kbText = KbConstants.kbText

    private var kbView: RecyclerView
    private var kbInput: EditText
    private var queryText = ""
    private lateinit var onSearchButtonPressedListener : OnSearchButtonPressedListener

    init {

            inflate(context,R.layout.tv_keyboard_view,this)


            kbView = findViewById(R.id.kb_view)
            kbInput = findViewById(R.id.search_input)

            kbView.adapter = KbAdapter(this)
            kbView.layoutManager = GridLayoutManager(context,6)
        }

    public fun addOnSearchButtonPressedListener(onSearchButtonPressedListener: OnSearchButtonPressedListener){
        this.onSearchButtonPressedListener = onSearchButtonPressedListener
    }

    override fun onButtonClicked(index: Int) {
        when(kbText[index]){
            "src" ->{
                onSearchButtonPressedListener.onSearchButtonPressed(queryText)
            }
            "del"->{
                queryText = queryText.dropLast(1)
            }
            "⎵"->{
                queryText += " "
            }
            "clr"->{
                queryText = ""
            }
            else->{
                queryText += kbText[index]

            }
        }
        kbInput.setText(queryText)
    }
}