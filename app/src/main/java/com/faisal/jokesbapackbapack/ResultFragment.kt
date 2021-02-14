package com.faisal.jokesbapackbapack

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.faisal.jokesbapackbapack.databinding.FragmentResultBinding

class ResultFragment : Fragment() {
    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // data binding
        _binding = FragmentResultBinding.inflate(inflater, container, false)
        val view = binding.root

        val viewModel: MyLiveData by activityViewModels()
        binding.pointTv.text = viewModel.point.toString()
        binding.progressCircular.progress = viewModel.point * 10
        when(viewModel.point) {
            0, 1 , 2, 3 -> {
                binding.resultTv.text = "Semangat belajar lagi jadi bapack bapack xixixi"
            }
            4, 5, 6 -> {
                binding.resultTv.text = "Lumayan bapack bapack juga anda xixixi"
            } else -> {
                binding.resultTv.text = "Selamat anda the real bapack bapack xixixi"
            }
        }
        binding.continueBtn.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_resultFragment_to_landingFragment)
        }
        return view

    }
}