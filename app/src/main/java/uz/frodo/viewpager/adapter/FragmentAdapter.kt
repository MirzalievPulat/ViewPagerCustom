package uz.frodo.viewpager.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import uz.frodo.viewpager.MainFragment
import uz.frodo.viewpager.model.User

class FragmentAdapter(var list:ArrayList<User>,fr: FragmentManager): FragmentStatePagerAdapter(fr,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Fragment {
        return MainFragment.newInstance(list,position)
    }

}