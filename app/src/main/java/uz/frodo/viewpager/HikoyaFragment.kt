package uz.frodo.viewpager

import android.content.Intent
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import uz.frodo.viewpager.databinding.FragmentHikoyaBinding
import uz.frodo.viewpager.model.Hi

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"

/**
 * A simple [Fragment] subclass.
 * Use the [HikoyaFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HikoyaFragment : Fragment() {
    lateinit var binding: FragmentHikoyaBinding
    // TODO: Rename and change types of parameters
    private var param1: Hi? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getParcelable(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHikoyaBinding.inflate(layoutInflater)

        binding.hikoyaImage.setImageResource(param1!!.image)
        binding.hikoyaName.text = param1!!.name
        binding.hikoyaText.text = param1!!.text

        binding.nextButton.setOnClickListener {
            val i = Intent(context,BlankActivity::class.java)
            startActivity(i)
            requireActivity().finish()
        }

        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HikoyaFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: Hi) =
            HikoyaFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_PARAM1, param1)
                }
            }
    }
}