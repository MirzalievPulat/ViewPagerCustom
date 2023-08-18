package uz.frodo.viewpager.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import uz.frodo.viewpager.HikoyaFragment
import uz.frodo.viewpager.model.Hi

class HikoyaAdapter(var list:ArrayList<Hi>, fr:FragmentManager):FragmentPagerAdapter(fr,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Fragment {
        return HikoyaFragment.newInstance(list[position])
    }
}