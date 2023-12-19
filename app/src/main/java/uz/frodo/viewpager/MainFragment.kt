package uz.frodo.viewpager

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import uz.frodo.viewpager.adapter.RvAdapter
import uz.frodo.viewpager.databinding.FragmentMainBinding
import uz.frodo.viewpager.model.ComingResult
import uz.frodo.viewpager.model.ResultX
import uz.frodo.viewpager.retrofit.Retrofit
import uz.frodo.viewpager.retrofit.RetrofitService

private const val ARG_PARAM1 = "param1"
class MainFragment : Fragment(),RvAdapter.ItemClick {
    lateinit var binding: FragmentMainBinding
    lateinit var tabName: String
    lateinit var request:Call<ComingResult>
    lateinit var list:List<ResultX>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            tabName = it.getString(ARG_PARAM1)!!
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(layoutInflater)
        val retrofit = Retrofit.getRetrofit(RetrofitService::class.java)

        when(tabName){
            "ALL" ->{
                request = retrofit.getPhotos("/",1,30,)
            }
            "NEW" ->{
                request = retrofit.getPhotos("/",1,30,"latest")
            }
            "ANIMALS" ->{
                request = retrofit.getPhotos("animals",1,30,)
            }
            "TECHNOLOGY" ->{
                request = retrofit.getPhotos("technology",1,30,)
            }
            "NATURE" ->{
                request = retrofit.getPhotos("nature",1,30,)
            }
            else -> {
                Toast.makeText(requireContext(), "Else", Toast.LENGTH_SHORT).show()
            }
        }

        request.enqueue(object :Callback<ComingResult>{
            override fun onResponse(call: Call<ComingResult>, response: Response<ComingResult>) {
                if (response.isSuccessful && response.body() != null){
                    val adapter = RvAdapter(this@MainFragment)
                    list = response.body()!!.results
                    adapter.submitList(list)
                    binding.rv.adapter = adapter
                }else{
                    Toast.makeText(requireContext(), "Error: ${response.code()}", Toast.LENGTH_SHORT).show()
                }
                binding.progressBar.visibility = View.GONE
            }

            override fun onFailure(call: Call<ComingResult>, t: Throwable) {
                Toast.makeText(requireContext(), "Failed", Toast.LENGTH_SHORT).show()
                binding.progressBar.visibility = View.GONE
            }
        })

        return binding.root
    }

    companion object {
        fun newInstance(tabName: String) =
            MainFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, tabName)
                }
            }
        var current = 0
    }

    override fun onStart() {
        super.onStart()
        println(current)
        binding.rv.scrollToPosition(current)
    }

    override fun onItemClick(resultX: ResultX) {
        val intent = Intent(requireContext(),Image::class.java)
        intent.putExtra("photo",resultX)
        startActivity(intent)
    }
}