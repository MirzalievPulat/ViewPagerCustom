package uz.frodo.viewpager.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.squareup.picasso.Picasso
import uz.frodo.viewpager.R

class RvAdapter(var list:ArrayList<String>,var onclick:onClick):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.re_item,parent,false)
        return object :ViewHolder(view){}
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val i = holder.itemView.findViewById<ImageView>(R.id.reItemImage)
        Picasso.get().load(list[position]).into(i)
        i.setOnClickListener {
            onclick.onClick(position)
        }
    }
    interface onClick{
        fun onClick(position: Int)
    }
}