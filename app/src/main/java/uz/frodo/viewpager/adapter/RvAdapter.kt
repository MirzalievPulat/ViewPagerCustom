package uz.frodo.viewpager.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.squareup.picasso.Picasso
import uz.frodo.viewpager.R
import uz.frodo.viewpager.databinding.ReItemBinding
import uz.frodo.viewpager.model.ResultX

class RvAdapter(private val itemClick: ItemClick): ListAdapter<ResultX,RvAdapter.MyViewHolder>(MyDiffUtil()) {
    class MyViewHolder(val binding:ReItemBinding): ViewHolder(binding.root)

    class MyDiffUtil: DiffUtil.ItemCallback<ResultX>(){
        override fun areItemsTheSame(oldItem: ResultX, newItem: ResultX): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ResultX, newItem: ResultX): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ReItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = getItem(position)

        Picasso.get().load(item.urls.regular).into(holder.binding.reItemImage)

        holder.binding.reItemImage.setOnClickListener {
            itemClick.onItemClick(item)
        }

    }

    interface ItemClick{
        fun onItemClick(resultX: ResultX)
    }

}