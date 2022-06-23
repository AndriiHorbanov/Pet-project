package com.example.test337

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.test337.databinding.FragmentThirdBinding
import com.example.test337.model.*


class ThirdFragment : Fragment() {

    private val viewModel: OrderViewModel by activityViewModels()

    private var _binding: FragmentThirdBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {


            thirdFragmentCancel.setOnClickListener {
                findNavController().navigate(R.id.action_thirdFragment_to_firstFragment2)
            }

            thirdFragmentNext.setOnClickListener {

                сoneWeight.forEach { weight ->
                    if (weight.buttonId == thirdHowMany.checkedRadioButtonId) {
                        viewModel.setWeight(weight.name)
                        viewModel.setAmount(weight.name)
                    }
                }

                coneVariety.forEach { variety ->
                    if (variety.buttonId == thirdChoiceVariety.checkedRadioButtonId) {
                        viewModel.setVariety(variety.name)
                        viewModel.setPrice(variety.name)
                    }
                }

                if (thirdSwitchGift.isChecked == GiftWrap.SwitchWrap.True.result) {
                    viewModel.setWarp(GiftWrap.SwitchWrap.True)
                } else {
                    viewModel.setWarp(GiftWrap.SwitchWrap.False)
                }

                it.findNavController().navigate(R.id.action_thirdFragment_to_result)

            }


        }
    }

}

