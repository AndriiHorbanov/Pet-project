package com.example.test337

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.test337.databinding.FragmentFourthBinding
import com.example.test337.model.*


class FourthFragment : Fragment() {

    private val viewModel: OrderViewModel by activityViewModels()

    private var _binding: FragmentFourthBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFourthBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.apply {

            fourthFragmentCancel.setOnClickListener {
                findNavController().navigate(R.id.action_thirdFragment_to_firstFragment2)
            }

            сigaretteWeight.forEach { weight ->
                if (weight.buttonId == fourthQuantity.checkedRadioButtonId) {
                    viewModel.setWeight(weight.name)
                    viewModel.setAmount(weight.name)
                }
            }

            fourthFragmentNext.setOnClickListener {
                therapeuticVariety.forEach { variety ->
                    if (variety.buttonId == radioChoiceFiller.checkedRadioButtonId) {
                        viewModel.setVariety(variety.name)
                        viewModel.setPrice(variety.name)
                    }
                }


                if (fourthSwitchSpliff.isChecked == GiftWrap.SwitchWrap.True.result) {
                    viewModel.setWarp(GiftWrap.SwitchWrap.True)
                } else {
                    viewModel.setWarp(GiftWrap.SwitchWrap.False)
                }

                it.findNavController().navigate(R.id.action_fourthFragment_to_result)


            }
        }
    }
}
