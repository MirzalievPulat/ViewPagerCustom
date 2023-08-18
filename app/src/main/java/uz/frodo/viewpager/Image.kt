package uz.frodo.viewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.os.bundleOf
import uz.frodo.viewpager.adapter.ImageAdapter
import uz.frodo.viewpager.databinding.ActivityImageBinding
import uz.frodo.viewpager.model.User

class Image : AppCompatActivity() {
    lateinit var binding: ActivityImageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val list = intent.getStringArrayListExtra("list")
        val position = intent.getIntExtra("position",-1)

        binding.imagePager.adapter = ImageAdapter(list!!)
        binding.imagePager.currentItem = position


    }

    override fun onPause() {
        super.onPause()
        MainFragment.current = binding.imagePager.currentItem
    }
}