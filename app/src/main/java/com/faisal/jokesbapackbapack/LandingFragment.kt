package com.faisal.jokesbapackbapack

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import com.faisal.jokesbapackbapack.databinding.FragmentLandingBinding


class LandingFragment : Fragment() {
    private var _binding: FragmentLandingBinding? = null
    private  val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // data binding
        _binding = FragmentLandingBinding.inflate(inflater, container, false)
        // inflate the layout of this fragment
        val view = binding.root

        binding.startBtn.setOnClickListener { Navigation.findNavController(view).navigate(R.id.action_landingFragment_to_gameFragment) }
        binding.shareBtn.setOnClickListener { Navigation.findNavController(view).navigate(R.id.navigatetoShareFragment) }
        binding.exitBtn.setOnClickListener {
            getActivity()?.finish()
        }
        return view
    }

}