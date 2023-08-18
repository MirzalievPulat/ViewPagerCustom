package uz.frodo.viewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.frodo.viewpager.databinding.ActivityHikoyaBinding
import uz.frodo.viewpager.R.drawable.*
import uz.frodo.viewpager.adapter.HikoyaAdapter
import uz.frodo.viewpager.model.Hi

class Hikoya : AppCompatActivity() {
    lateinit var binding : ActivityHikoyaBinding
    lateinit var list:ArrayList<Hi>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHikoyaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadList()
        binding.hikoyaPager.adapter = HikoyaAdapter(list,supportFragmentManager)
        binding.hikoyaTab.setupWithViewPager(binding.hikoyaPager)

    }

    private fun loadList() {
        list = ArrayList()
        list.add(Hi(bitmap,"Xush kelibsiz","Kim ko‘rubdur, ey ko‘ngul, ahli jahondin yaxshilig‘, \n" +
                "Kimki, ondin yaxshi yo‘q, ko‘z tutma ondin yaxshilig‘"))
        list.add(Hi(bitmap2,"Hikoyalar dunyosi","Gar zamonni nayf qilsam ayb qilma, ey rafiq, \n" +
                "Ko‘rmadim hargiz, netoyin, bu zamondin yaxshilig‘ ! "))
        list.add(Hi(bitmap3,"Kitob ortidan..","Dilrabolardin yomonliq keldi mahzun ko‘ngluma,\n" +
                " Kelmadi jonimg'a hech oromi jondin yaxshilig'."))
        list.add(Hi(bitmap4,"Bizga qo`shiling","Ey ko‘ngul, chun yaxshidin ko‘rdung yamonliq asru ko‘p,\n" +
                " Emdi ko‘z tutmoq ne ma’ni har yamondin yaxshilig'?"))
    }
}
