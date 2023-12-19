package uz.frodo.viewpager.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import uz.frodo.viewpager.MainFragment

class FragmentStateAdapter(activity:FragmentActivity, private val list:ArrayList<String>):FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return list.size
    }

    override fun createFragment(position: Int): Fragment = MainFragment.newInstance(list[position])
}