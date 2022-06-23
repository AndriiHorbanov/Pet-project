package com.example.test337

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.get
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.test337.databinding.FragmentSecondBinding
import com.example.test337.model.OrderViewModel
import com.example.test337.model.ProductType


class SecondFragment : Fragment() {

    private val viewModel: OrderViewModel by activityViewModels()

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val myAdapter = ViewPagerAdapter(this)
        binding.apply {
            viewPadger.adapter = myAdapter
            viewModel.productType.observe(viewLifecycleOwner) { type ->
                viewPadger.currentItem = type.number
                productType.check(productType[type.number].id)
            }

            viewPadger.registerOnPageChangeCallback(object :
                ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    viewModel.setType(
                        when (position) {
                            0 -> ProductType.Cone
                            1 -> ProductType.Therapeutic
                            else -> ProductType.Cigarette
                        }
                    )
                }
            })

            productType.setOnCheckedChangeListener() { _, id ->
                viewModel.setType(
                    when (id) {
                        R.id.hash_type -> ProductType.Cone
                        R.id.sbd_type -> ProductType.Therapeutic
                        else -> ProductType.Cigarette

                    }
                )
            }

            secondFragmentCancel.setOnClickListener {
                findNavController().navigate(R.id.action_secondFragment2_to_firstFragment2)
            }
            buttonIdSecondFragmentNext.setOnClickListener {
                when (productType.checkedRadioButtonId) {
                    R.id.hash_type -> {
                        findNavController().navigate(R.id.action_secondFragment2_to_thirdFragment)
                        viewModel.setType(ProductType.Cone)
                    }

                    R.id.sbd_type -> {
                        findNavController().navigate(R.id.action_secondFragment2_to_fifthFragment)
                        viewModel.setType(ProductType.Therapeutic)
                    }

                    R.id.spliff_type -> {
                        findNavController().navigate(R.id.action_secondFragment2_to_fourthFragment)
                        viewModel.setType(ProductType.Cigarette)
                    }
                }


            }


        }
    }

    inner class ViewPagerAdapter(fm: Fragment) : FragmentStateAdapter(fm) {

        private val imageList =
            listOf(R.drawable.magic, R.drawable.therapeutic, R.drawable.cigarette)

        override fun getItemCount(): Int {
            return imageList.size
        }

        override fun createFragment(position: Int): Fragment {
            val fragmentImage = FragmentImage()
            fragmentImage.arguments = bundleOf(KEY to imageList[position])
            return fragmentImage
        }


    }

    companion object {
        const val KEY = "Ya"
    }
}