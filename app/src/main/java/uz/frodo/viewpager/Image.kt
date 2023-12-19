package uz.frodo.viewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import uz.frodo.viewpager.databinding.ActivityImageBinding
import uz.frodo.viewpager.model.ResultX

class Image : AppCompatActivity() {
    lateinit var binding: ActivityImageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val resultX = intent.getSerializableExtra("photo") as ResultX

        Picasso.get().load(resultX.urls.regular).into(binding.itemImage)

    }

}