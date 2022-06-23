package com.example.test337

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.test337.SecondFragment.Companion.KEY
import com.example.test337.databinding.ImageFragmentBinding


class FragmentImage : Fragment() {

    private var _binding: ImageFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ImageFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val arg = arguments?.getInt(KEY)
        arg?.let { binding.root.setImageResource(arg) }
    }


}
