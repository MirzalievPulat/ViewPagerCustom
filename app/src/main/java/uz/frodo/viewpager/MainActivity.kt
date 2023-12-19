package uz.frodo.viewpager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import uz.frodo.viewpager.adapter.FragmentStateAdapter
import uz.frodo.viewpager.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var list:ArrayList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)



        list = arrayListOf(
            "ALL",
            "NEW",
            "ANIMALS",
            "TECHNOLOGY",
            "NATURE")

        binding.viewPager.adapter = FragmentStateAdapter(this,list)
        TabLayoutMediator(binding.homeTab,binding.viewPager ){ tab, pos ->
            tab.text = list[pos]
            binding.viewPager.setCurrentItem(tab.position,true)





        }.attach()

    }

}