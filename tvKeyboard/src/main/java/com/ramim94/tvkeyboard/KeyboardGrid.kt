package com.ramim94.tvkeyboard

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class KbAdapter(val kbInterface: KbInterface) : RecyclerView.Adapter<KeyboardEachKey>() {
    private val kbText = KbConstants.kbText

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KeyboardEachKey {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.single_kb_key, parent, false)
        return KeyboardEachKey(kbInterface, view)
    }

    override fun onBindViewHolder(holder: KeyboardEachKey, position: Int) {
        when(kbText[position]){
            "src" -> {
//                Glide.with(holder.itemView.context)
//                        .load(R.drawable.ic_search)
//                        .apply(RequestOptions().fitCenter())
//                        .into(holder.kbImageKey)

                holder.kbImageKey
                    .setImageDrawable(
                    ResourcesCompat.getDrawable(
                        holder.itemView.resources,
                        R.drawable.ic_search,
                        holder.itemView.context.theme))


                holder.kbImageKey.visibility = View.VISIBLE
                holder.kbKey.visibility = View.INVISIBLE
            }
            "del" -> {
                Glide.with(holder.itemView.context)
                        .load(R.drawable.ic_backspace)
                        .apply(RequestOptions().fitCenter())
                        .into(holder.kbImageKey)
                holder.kbImageKey.visibility = View.VISIBLE
                holder.kbKey.visibility = View.INVISIBLE
            }
            "clr" -> {
                Glide.with(holder.itemView.context)
                        .load(R.drawable.ic_delete)
                        .apply(RequestOptions().fitCenter())
                        .into(holder.kbImageKey)
                holder.kbImageKey.visibility = View.VISIBLE
                holder.kbKey.visibility = View.INVISIBLE
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

        itemView.setOnFocusChangeListener { v, hasFocus ->
            if(hasFocus){
                v.scaleX = 0.9f
                v.scaleY = 0.9f
                v.elevation = 0.2f
            }else{
                v.scaleX = 1.0f
                v.scaleY = 1.0f
                v.elevation=0f
            }
            kbInterface.onSelectedItemChanged(adapterPosition)
        }
    }
}