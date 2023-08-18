package uz.frodo.viewpager

import android.content.Intent
import android.os.Bundle
import android.os.Parcel
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import uz.frodo.viewpager.adapter.RvAdapter
import uz.frodo.viewpager.databinding.FragmentMainBinding
import uz.frodo.viewpager.model.User
import java.text.FieldPosition
import kotlin.properties.Delegates

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment() {
    lateinit var binding: FragmentMainBinding
    // TODO: Rename and change types of parameters
    lateinit var param1: ArrayList<User>
    var param2 by Delegates.notNull<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getParcelableArrayList(ARG_PARAM1)!!
            param2 = it.getInt(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(layoutInflater)

        binding.rv.adapter = RvAdapter(param1[param2].image,object :RvAdapter.onClick{
            override fun onClick(position: Int) {
                val i  = Intent(requireContext(),Image::class.java)
                i.putExtra("list",param1[param2].image)
                i.putExtra("position",position)
                startActivity(i)
            }
        })

        return binding.root
    }

    companion object {
        fun newInstance(param1: ArrayList<User>,param2:Int) =
            MainFragment().apply {
                arguments = Bundle().apply {
                    putParcelableArrayList(ARG_PARAM1, param1)
                    putInt(ARG_PARAM2,param2)
                }
            }
        var current = 0
    }

    override fun onStart() {
        super.onStart()
        println(current)
        binding.rv.scrollToPosition(current)
    }
}