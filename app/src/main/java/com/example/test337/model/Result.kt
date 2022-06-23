package com.example.test337.model

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.test337.R
import com.example.test337.R.string.*
import com.example.test337.databinding.FragmentResultBinding
import java.lang.Exception
import java.text.NumberFormat

class Result : Fragment() {

    private val viewModel: OrderViewModel by activityViewModels()

    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.apply {
            (getString(ResultVariety) + " " + getString(viewModel.varietyWeed.value!!)).also {
                resultVariety.text = it
            }
            (getString(ResultWeight) + "" + getString(viewModel.weightWeed.value!!)).also {
                resultWeight.text = it
            }
            (getString(ResultType) + " " + getString(viewModel.productType.value?.name!!)).also {
                resultType.text = it
            }
            (getString(ResultWarp) + " " + getString(viewModel.giftWrap.value!!)).also {
                resultGiftWrap.text = it
            }
            textPrice.text = getString(
                price_result,
                NumberFormat.getCurrencyInstance().format(viewModel.price.value)
            )

            resultCancel.setOnClickListener { findNavController().navigate(R.id.action_result_to_firstFragment2) }

            resultNext.setOnClickListener {
                sendOrder()
            }


        }
    }

    private fun sendOrder() {
        val order = getString(
            order_details,
            binding.resultType.text,
            binding.resultVariety.text,
            binding.resultWeight.text,
            binding.resultGiftWrap.text,
            binding.textPrice.text
        )

        val intent = Intent().apply {
            action = Intent.ACTION_SENDTO
            data = Uri.parse("mailto:")
            putExtra(Intent.EXTRA_EMAIL, arrayOf<String>("doima1998doima1998@gmail.com"))
            putExtra(Intent.EXTRA_SUBJECT, getString(R.string.order))
            putExtra(Intent.EXTRA_TEXT, order)
        }

        try {
            startActivity(intent)
        } catch (e:Exception) {
            Toast.makeText(context, "You don't have an email application", Toast.LENGTH_LONG).show()
        }
    }

}