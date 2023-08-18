package uz.frodo.viewpager.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import com.squareup.picasso.Picasso
import uz.frodo.viewpager.R
import uz.frodo.viewpager.databinding.ItemBinding

class ImageAdapter(var list:ArrayList<String>): PagerAdapter() {
    override fun getCount(): Int {
        return list.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = LayoutInflater.from(container.context).inflate(R.layout.item,container,false)
        val i = view.findViewById<ImageView>(R.id.item_image)
        Picasso.get().load(list[position]).into(i)
        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)

    }

}