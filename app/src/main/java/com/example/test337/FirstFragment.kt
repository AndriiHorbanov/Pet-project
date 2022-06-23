package com.example.test337

import  android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.test337.databinding.FragmentFirstBinding
import com.example.test337.model.OrderViewModel


class FirstFragment : Fragment() {

    private val viewModel: OrderViewModel by activityViewModels()

    private var _binding: FragmentFirstBinding?=null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.firstButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_firstFragment2_to_secondFragment2)
        }
    }


}