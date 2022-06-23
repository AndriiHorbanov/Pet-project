package com.example.test337

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.test337.databinding.FragmentFifthBinding
import com.example.test337.model.GiftWrap
import com.example.test337.model.OrderViewModel
import com.example.test337.model.therapeuticVariety
import com.example.test337.model.medicalWeight

class FifthFragment : Fragment() {

    private val viewModel: OrderViewModel by activityViewModels()

    private var _binding: FragmentFifthBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        _binding = FragmentFifthBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.apply {

            fifthFragmentCancel.setOnClickListener {
             findNavController().navigate(R.id.action_fifthFragment_to_firstFragment2)
            }

            fifthFragmentNext.setOnClickListener {

                medicalWeight.forEach { weight->
                    if (weight.buttonId == fifthHowManyCbd.checkedRadioButtonId){
                        viewModel.setWeight(weight.name)
                        viewModel.setAmount(weight.name)
                    }
                }

                therapeuticVariety.forEach { variety->
                    if (variety.buttonId == fifthChoiceCbd.checkedRadioButtonId){
                        viewModel.setVariety(variety.name)
                        viewModel.setPrice(variety.name)
                    }
                }


                if (fifthSwitchCbd.isChecked == GiftWrap.SwitchWrap.True.result){
                    viewModel.setWarp(GiftWrap.SwitchWrap.True)
                }else{
                    viewModel.setWarp(GiftWrap.SwitchWrap.False)
                }

                it.findNavController().navigate(R.id.action_fifthFragment_to_result)
            }
        }
    }

}
