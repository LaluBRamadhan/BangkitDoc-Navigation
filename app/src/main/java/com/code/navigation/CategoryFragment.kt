package com.code.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.code.navigation.databinding.FragmentCategoryBinding



class CategoryFragment : Fragment() {

    private var _binding: FragmentCategoryBinding? = null
    private val binding get() = _binding!!

    companion object{
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_STOCK = "extra_stock"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCategoryBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        metode bundle
//        binding.btnCategoryLifestyle.setOnClickListener{
//            val mBundle = Bundle()
//            mBundle.putString(EXTRA_NAME, "Lifestyle")
//            mBundle.putLong(EXTRA_STOCK,7)
//            view.findNavController().navigate(R.id.action_categoryFragment_to_detailCategoryFragment, mBundle)
//        }

        //metode safeArgs
        binding.btnCategoryLifestyle.setOnClickListener{
            val toDetailCategoryFragment = CategoryFragmentDirections.actionCategoryFragmentToDetailCategoryFragment()
            toDetailCategoryFragment.name = "Lifestyle"
            toDetailCategoryFragment.stock = 7
            view.findNavController().navigate(toDetailCategoryFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}