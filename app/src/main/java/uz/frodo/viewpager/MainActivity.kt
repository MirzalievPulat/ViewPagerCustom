package uz.frodo.viewpager

import Transform
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.core.os.postDelayed
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import uz.frodo.viewpager.R.drawable.*
import uz.frodo.viewpager.adapter.FragmentAdapter
import uz.frodo.viewpager.adapter.PagerAdapterr
import uz.frodo.viewpager.databinding.ActivityMainBinding
import uz.frodo.viewpager.databinding.TabItemBinding
import uz.frodo.viewpager.model.User
import javax.xml.transform.Transformer

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var list:ArrayList<User>
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val all = arrayListOf(
            "https://img.freepik.com/free-photo/wide-angle-shot-single-tree-growing-clouded-sky-during-sunset-surrounded-by-grass_181624-22807.jpg?w=2000",
            "https://cdn.pixabay.com/photo/2018/02/02/17/29/nature-3125912_1280.jpg",
            "https://images.unsplash.com/photo-1667745537858-ca2f89e31591?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTF8fHBlY3N8ZW58MHx8MHx8&w=1000&q=80",
            "https://images.unsplash.com/photo-1635339713030-4995d994c638?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1yZWxhdGVkfDE0fHx8ZW58MHx8fHx8&w=1000&q=80",
           "https://img.freepik.com/premium-photo/beautiful-landscape-based-3d-rendering-illustration_771975-25.jpg?w=2000",
            "https://images.unsplash.com/photo-1615277344987-e171cce9323a?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1yZWxhdGVkfDE4fHx8ZW58MHx8fHx8&w=1000&q=80",
            "https://media.istockphoto.com/id/108221452/photo/beautiful-zion-national-park-landscape.jpg?s=612x612&w=0&k=20&c=BZ8DGhpyJf0gRMEKyJTDEwC2wH-vQcQXPyI0806WZso=",
            "https://cdn.pixabay.com/photo/2015/12/01/20/28/road-1072823_640.jpg",
            "https://static.sadhguru.org/d/46272/1633199491-1633199490440.jpg",
            "https://img.freepik.com/free-photo/cardano-blockchain-platform_23-2150411956.jpg",
            "https://media.istockphoto.com/id/1296904409/photo/artificial-intelligence-and-technology.jpg?s=170667a&w=0&k=20&c=yogplmj0EeuSy0z7SOLE-CKQCtQqmmKP2dMWXubX1X4=",
            "https://media.istockphoto.com/id/1203511380/photo/business-technology-internet-and-network-concept-technical-support-center-customer-service.jpg?s=170667a&w=0&k=20&c=lIESENtWOwazXnYmFOHgJK6WUTlxgPdV985DjmL9ZQI=",
            "https://transcosmos.co.uk/wp-content/uploads/2015/10/technology-customer-support1.jpg",
            "https://www.techbooky.com/wp-content/uploads/2018/04/technology-and-us-scaled.jpg",
            "https://www.yondu.com/wp-content/uploads/2022/08/OPT-2-medium-shot-man-wearing-vr-glasses-scaled.jpg",
            "https://media.istockphoto.com/id/1324380506/photo/people-with-vr-grasses-playing-virtual-reality-game-future-digital-technology-and-3d-virtual.jpg?s=612x612&w=0&k=20&c=I_9fnEi1hNHFwy0qe8g7V1ZQJmgyKEDOSDJonScTSMU=",
            "https://media.wired.com/photos/5a0e13169639c5682ccdf3b2/1:1/w_887,h_887,c_limit/Atlas-FinalArt.jpg",
            "https://media.wired.com/photos/593261cab8eb31692072f129/master/w_2560%2Cc_limit/85120553.jpg",
            "https://cdn0.projetecolo.com/fr/posts/1/2/1/animaux_du_desert_du_sahara_noms_caracteristiques_et_photos_121_600.jpg",
            "https://images.unsplash.com/photo-1598755257130-c2aaca1f061c?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8M3x8d2lsZCUyMGFuaW1hbHxlbnwwfHwwfHx8MA%3D%3D&w=1000&q=80",
            "https://hips.hearstapps.com/hmg-prod/images/cute-baby-animals-1558535060.jpg",
            "https://cms.londonzoo.org/sites/default/files/styles/responsive/public/1440/729/1/2022-11/Asim-at-London-Zoo.jpg?itok=sxChnnU-",
            "https://www.marylandzoo.org/wp-content/uploads/2018/04/lemuranimaheader3.jpg",
            "https://img.freepik.com/free-photo/medium-shot-smiley-kids-posing-together_23-2149073581.jpg",
            "https://images.pexels.com/photos/34098/south-africa-hluhluwe-giraffes-pattern.jpg?cs=srgb&dl=pexels-pixabay-34098.jpg&fm=jpg",
            "https://skysailtechnologies.com/wp-content/uploads/2021/01/30212411048_2a1d7200e2_z-1.jpg",
            "https://www.cdc.gov/vaccines/parents/images/smiling-family.png?_=77702",

            )

        val new = arrayListOf<String>(
            "https://www.marylandzoo.org/wp-content/uploads/2018/04/lemuranimaheader3.jpg",
            "https://img.freepik.com/free-photo/medium-shot-smiley-kids-posing-together_23-2149073581.jpg",
            "https://images.pexels.com/photos/34098/south-africa-hluhluwe-giraffes-pattern.jpg?cs=srgb&dl=pexels-pixabay-34098.jpg&fm=jpg",
            "https://skysailtechnologies.com/wp-content/uploads/2021/01/30212411048_2a1d7200e2_z-1.jpg",
            "https://www.cdc.gov/vaccines/parents/images/smiling-family.png?_=77702",
            "https://wcm-cdn.wacom.com/-/media/images/carousels/homepage-a-slots/chromebook/one-by-wacom-one-by-wacom-now-also-works-with-chromebook-v3-hf-mo.jpg?h=450&iar=0&w=726&rev=a2f272718a8944fb8222da61eb31e395&hash=2212E0B60B3CFFB742F31FB1BDA2852E",
            "https://a-z-animals.com/media/2021/01/Wild-Chameleon-Reptile-With-Beautiful-Colors-400x300.jpg",
            "https://i.natgeofe.com/k/63b1a8a7-0081-493e-8b53-81d01261ab5d/red-panda-full-body_3x4.jpg",
        "https://www.marylandzoo.org/wp-content/uploads/2018/04/lemuranimaheader3.jpg",
            "https://img.freepik.com/free-photo/medium-shot-smiley-kids-posing-together_23-2149073581.jpg",
            "https://images.pexels.com/photos/34098/south-africa-hluhluwe-giraffes-pattern.jpg?cs=srgb&dl=pexels-pixabay-34098.jpg&fm=jpg",
            "https://skysailtechnologies.com/wp-content/uploads/2021/01/30212411048_2a1d7200e2_z-1.jpg",
            "https://www.cdc.gov/vaccines/parents/images/smiling-family.png?_=77702",
            "https://wcm-cdn.wacom.com/-/media/images/carousels/homepage-a-slots/chromebook/one-by-wacom-one-by-wacom-now-also-works-with-chromebook-v3-hf-mo.jpg?h=450&iar=0&w=726&rev=a2f272718a8944fb8222da61eb31e395&hash=2212E0B60B3CFFB742F31FB1BDA2852E",
            "https://a-z-animals.com/media/2021/01/Wild-Chameleon-Reptile-With-Beautiful-Colors-400x300.jpg",
            "https://i.natgeofe.com/k/63b1a8a7-0081-493e-8b53-81d01261ab5d/red-panda-full-body_3x4.jpg",
        )
        val animals = arrayListOf<String>(
            "https://media.wired.com/photos/593261cab8eb31692072f129/master/w_2560%2Cc_limit/85120553.jpg",
            "https://cdn0.projetecolo.com/fr/posts/1/2/1/animaux_du_desert_du_sahara_noms_caracteristiques_et_photos_121_600.jpg",
            "https://images.unsplash.com/photo-1598755257130-c2aaca1f061c?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8M3x8d2lsZCUyMGFuaW1hbHxlbnwwfHwwfHx8MA%3D%3D&w=1000&q=80",
            "https://hips.hearstapps.com/hmg-prod/images/cute-baby-animals-1558535060.jpg",
            "https://cms.londonzoo.org/sites/default/files/styles/responsive/public/1440/729/1/2022-11/Asim-at-London-Zoo.jpg?itok=sxChnnU-",
            "https://expeditionsonline.com/application/files/cache/176630e8ba63cd41521253e1c8d5f917.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3c/Giant_Panda_2004-03-2.jpg/1200px-Giant_Panda_2004-03-2.jpg",
            "https://ideas.ted.com/wp-content/uploads/sites/3/2020/05/final_animals-homeschooling_credit-alamy.jpg",
            "https://aldf.org/wp-content/uploads/2018/05/lamb-iStock-665494268-16x9-e1559777676675.jpg",
      "https://media.wired.com/photos/593261cab8eb31692072f129/master/w_2560%2Cc_limit/85120553.jpg",
            "https://cdn0.projetecolo.com/fr/posts/1/2/1/animaux_du_desert_du_sahara_noms_caracteristiques_et_photos_121_600.jpg",
            "https://images.unsplash.com/photo-1598755257130-c2aaca1f061c?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8M3x8d2lsZCUyMGFuaW1hbHxlbnwwfHwwfHx8MA%3D%3D&w=1000&q=80",
            "https://hips.hearstapps.com/hmg-prod/images/cute-baby-animals-1558535060.jpg",
            "https://cms.londonzoo.org/sites/default/files/styles/responsive/public/1440/729/1/2022-11/Asim-at-London-Zoo.jpg?itok=sxChnnU-",
            "https://expeditionsonline.com/application/files/cache/176630e8ba63cd41521253e1c8d5f917.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3c/Giant_Panda_2004-03-2.jpg/1200px-Giant_Panda_2004-03-2.jpg",
            "https://ideas.ted.com/wp-content/uploads/sites/3/2020/05/final_animals-homeschooling_credit-alamy.jpg",
            "https://aldf.org/wp-content/uploads/2018/05/lamb-iStock-665494268-16x9-e1559777676675.jpg"
        )
        val technology = arrayListOf<String>(
            "https://img.freepik.com/free-photo/cardano-blockchain-platform_23-2150411956.jpg",
            "https://media.istockphoto.com/id/1296904409/photo/artificial-intelligence-and-technology.jpg?s=170667a&w=0&k=20&c=yogplmj0EeuSy0z7SOLE-CKQCtQqmmKP2dMWXubX1X4=",
            "https://media.istockphoto.com/id/1203511380/photo/business-technology-internet-and-network-concept-technical-support-center-customer-service.jpg?s=170667a&w=0&k=20&c=lIESENtWOwazXnYmFOHgJK6WUTlxgPdV985DjmL9ZQI=",
            "https://transcosmos.co.uk/wp-content/uploads/2015/10/technology-customer-support1.jpg",
            "https://www.techbooky.com/wp-content/uploads/2018/04/technology-and-us-scaled.jpg",
            "https://www.yondu.com/wp-content/uploads/2022/08/OPT-2-medium-shot-man-wearing-vr-glasses-scaled.jpg",
            "https://media.istockphoto.com/id/1324380506/photo/people-with-vr-grasses-playing-virtual-reality-game-future-digital-technology-and-3d-virtual.jpg?s=612x612&w=0&k=20&c=I_9fnEi1hNHFwy0qe8g7V1ZQJmgyKEDOSDJonScTSMU=",
            "https://media.wired.com/photos/5a0e13169639c5682ccdf3b2/1:1/w_887,h_887,c_limit/Atlas-FinalArt.jpg",
            "https://challenge.carleton.ca/wp-content/uploads/2022/02/cern-atlas-collider-1200x700-1.jpg",
            "https://s.yimg.com/uu/api/res/1.2/doKf0LrdxQzNGEA3xDHD7g--~B/Zmk9ZmlsbDtoPTU4Mzt3PTg3NTthcHBpZD15dGFjaHlvbg--/https://media-mbst-pub-ue1.s3.amazonaws.com/creatr-images/2020-06/0fd49980-b461-11ea-8cbf-32d92631b3d5.cf.jpg",
            "https://images.newscientist.com/wp-content/uploads/2021/12/21160600/PRI_215047003.jpg",
            "https://ems-entertainment.com/wp-content/uploads/2017/02/DSC_5669.jpg",
            "https://img.freepik.com/free-photo/cardano-blockchain-platform_23-2150411956.jpg",
            "https://media.istockphoto.com/id/1296904409/photo/artificial-intelligence-and-technology.jpg?s=170667a&w=0&k=20&c=yogplmj0EeuSy0z7SOLE-CKQCtQqmmKP2dMWXubX1X4=",
            "https://media.istockphoto.com/id/1203511380/photo/business-technology-internet-and-network-concept-technical-support-center-customer-service.jpg?s=170667a&w=0&k=20&c=lIESENtWOwazXnYmFOHgJK6WUTlxgPdV985DjmL9ZQI=",
            "https://transcosmos.co.uk/wp-content/uploads/2015/10/technology-customer-support1.jpg",
            "https://www.techbooky.com/wp-content/uploads/2018/04/technology-and-us-scaled.jpg",
            "https://www.yondu.com/wp-content/uploads/2022/08/OPT-2-medium-shot-man-wearing-vr-glasses-scaled.jpg",
            "https://media.istockphoto.com/id/1324380506/photo/people-with-vr-grasses-playing-virtual-reality-game-future-digital-technology-and-3d-virtual.jpg?s=612x612&w=0&k=20&c=I_9fnEi1hNHFwy0qe8g7V1ZQJmgyKEDOSDJonScTSMU=",
            "https://media.wired.com/photos/5a0e13169639c5682ccdf3b2/1:1/w_887,h_887,c_limit/Atlas-FinalArt.jpg",
            "https://challenge.carleton.ca/wp-content/uploads/2022/02/cern-atlas-collider-1200x700-1.jpg",
            "https://s.yimg.com/uu/api/res/1.2/doKf0LrdxQzNGEA3xDHD7g--~B/Zmk9ZmlsbDtoPTU4Mzt3PTg3NTthcHBpZD15dGFjaHlvbg--/https://media-mbst-pub-ue1.s3.amazonaws.com/creatr-images/2020-06/0fd49980-b461-11ea-8cbf-32d92631b3d5.cf.jpg",
            "https://images.newscientist.com/wp-content/uploads/2021/12/21160600/PRI_215047003.jpg",
            "https://ems-entertainment.com/wp-content/uploads/2017/02/DSC_5669.jpg"
        )
        val nature = arrayListOf<String>(
            "https://img.freepik.com/free-photo/wide-angle-shot-single-tree-growing-clouded-sky-during-sunset-surrounded-by-grass_181624-22807.jpg?w=2000",
            "https://cdn.pixabay.com/photo/2018/02/02/17/29/nature-3125912_1280.jpg",
            "https://images.unsplash.com/photo-1667745537858-ca2f89e31591?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTF8fHBlY3N8ZW58MHx8MHx8&w=1000&q=80",
            "https://images.unsplash.com/photo-1635339713030-4995d994c638?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1yZWxhdGVkfDE0fHx8ZW58MHx8fHx8&w=1000&q=80",
            "https://cdn.pixabay.com/photo/2014/02/27/16/10/flowers-276014_640.jpg",
            "https://thumbs.dreamstime.com/b/spring-summer-nature-background-grass-trees-branch-green-leaves-sun-rays-bokeh-48829614.jpg",
            "https://st2.depositphotos.com/4231139/9783/i/950/depositphotos_97834694-stock-photo-sunlight-in-the-green-forest.jpg",
            "https://img.freepik.com/premium-photo/beautiful-landscape-based-3d-rendering-illustration_771975-25.jpg?w=2000",
            "https://images.unsplash.com/photo-1615277344987-e171cce9323a?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1yZWxhdGVkfDE4fHx8ZW58MHx8fHx8&w=1000&q=80",
            "https://media.istockphoto.com/id/108221452/photo/beautiful-zion-national-park-landscape.jpg?s=612x612&w=0&k=20&c=BZ8DGhpyJf0gRMEKyJTDEwC2wH-vQcQXPyI0806WZso=",
            "https://cdn.pixabay.com/photo/2015/12/01/20/28/road-1072823_640.jpg",
            "https://static.sadhguru.org/d/46272/1633199491-1633199490440.jpg",
       "https://img.freepik.com/free-photo/wide-angle-shot-single-tree-growing-clouded-sky-during-sunset-surrounded-by-grass_181624-22807.jpg?w=2000",
            "https://cdn.pixabay.com/photo/2018/02/02/17/29/nature-3125912_1280.jpg",
            "https://images.unsplash.com/photo-1667745537858-ca2f89e31591?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTF8fHBlY3N8ZW58MHx8MHx8&w=1000&q=80",
            "https://images.unsplash.com/photo-1635339713030-4995d994c638?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1yZWxhdGVkfDE0fHx8ZW58MHx8fHx8&w=1000&q=80",
            "https://cdn.pixabay.com/photo/2014/02/27/16/10/flowers-276014_640.jpg",
            "https://thumbs.dreamstime.com/b/spring-summer-nature-background-grass-trees-branch-green-leaves-sun-rays-bokeh-48829614.jpg",
            "https://st2.depositphotos.com/4231139/9783/i/950/depositphotos_97834694-stock-photo-sunlight-in-the-green-forest.jpg",
            "https://img.freepik.com/premium-photo/beautiful-landscape-based-3d-rendering-illustration_771975-25.jpg?w=2000",
            "https://images.unsplash.com/photo-1615277344987-e171cce9323a?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1yZWxhdGVkfDE4fHx8ZW58MHx8fHx8&w=1000&q=80",
            "https://media.istockphoto.com/id/108221452/photo/beautiful-zion-national-park-landscape.jpg?s=612x612&w=0&k=20&c=BZ8DGhpyJf0gRMEKyJTDEwC2wH-vQcQXPyI0806WZso=",
            "https://cdn.pixabay.com/photo/2015/12/01/20/28/road-1072823_640.jpg",
            "https://static.sadhguru.org/d/46272/1633199491-1633199490440.jpg"
        )

        list = arrayListOf(
            User("ALL", all),
            User("NEW", new),
            User("ANIMALS", animals),
            User("TECHNOLOGY", technology),
            User("NATURE", nature)
        )
        binding.viewPager.adapter = FragmentAdapter(list,supportFragmentManager)
        binding.tab.setupWithViewPager(binding.viewPager)

        setTab()
        binding.tab.addOnTabSelectedListener(object :OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab!!.customView!!.findViewById<View>(R.id.tab_view).visibility = View.VISIBLE
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                tab!!.customView!!.findViewById<View>(R.id.tab_view).visibility = View.INVISIBLE
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })
    }

    private fun setTab() {
        for (i in 0 until binding.tab.tabCount) {
            val tab = TabItemBinding.inflate(layoutInflater)
            tab.tabText.text = list[i].name

            binding.tab.getTabAt(i)?.customView = tab.root

            if (i == 0){
                tab.tabView.visibility = View.VISIBLE
            }else{
                tab.tabView.visibility = View.INVISIBLE
            }
        }
    }


}