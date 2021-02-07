package com.ramim94.tvkeyboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class KbAdapter(val kbInterface: KbInterface) : RecyclerView.Adapter<KeyboardEachKey>() {
    private val kbText = KbConstants.kbText

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KeyboardEachKey {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.single_kb_key, parent, false)
        view.setOnFocusChangeListener { v, hasFocus ->
            if(hasFocus){
                v.animate().scaleX(1.5f)
                v.animate().scaleY(1.5f)
            }else{
                v.animate().scaleX(1.0f)
                v.animate().scaleY(1.0f)
            }
        }
        return KeyboardEachKey(kbInterface, view)
    }

    override fun onBindViewHolder(holder: KeyboardEachKey, position: Int) {
        when(kbText[position]){
            "src" ->{
                Glide.with(holder.itemView.context)
                    .load(R.drawable.ic_search)
                    .into(holder.kbImageKey)

                holder.kbImageKey.visibility=View.VISIBLE
                holder.kbKey.visibility=View.INVISIBLE
            }
            "del"->{
                Glide.with(holder.itemView.context)
                    .load(R.drawable.ic_backspace)
                    .into(holder.kbImageKey)
                holder.kbImageKey.visibility=View.VISIBLE
                holder.kbKey.visibility=View.INVISIBLE
            }
            "clr"->{
                Glide.with(holder.itemView.context)
                    .load(R.drawable.ic_delete)
                    .into(holder.kbImageKey)
                holder.kbImageKey.visibility=View.VISIBLE
                holder.kbKey.visibility=View.INVISIBLE
            }
            else->{
                holder.kbKey.text = kbText[position]
                holder.kbImageKey.visibility=View.INVISIBLE
                holder.kbKey.visibility=View.VISIBLE
            }
        }
    }

    override fun getItemCount(): Int {
        return kbText.size
    }

}


class KeyboardEachKey(kbInterface: KbInterface, itemView: View) : RecyclerView.ViewHolder(itemView) {
    val kbKey : TextView = itemView.findViewById(R.id.kb_key)
    val kbImageKey : ImageView = itemView.findViewById(R.id.kb_img_key)

    init {
        itemView.setOnClickListener {
            kbInterface.onButtonClicked(adapterPosition)
        }
    }
}