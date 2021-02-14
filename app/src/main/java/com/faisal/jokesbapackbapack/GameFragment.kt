package com.faisal.jokesbapackbapack

import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.faisal.jokesbapackbapack.databinding.FragmentGameBinding
import com.poovam.pinedittextfield.SquarePinField
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*
import java.util.concurrent.ThreadFactory
import kotlin.collections.ArrayList
import kotlin.math.log

class GameFragment : Fragment() {

    private var _binding: FragmentGameBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // data binding
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        val view = binding.root
        // call View Model
        val viewModel: MyLiveData by activityViewModels()
        viewModel.callQnA()
        var index = 0
        var answer = setQuestion(binding.tvQuestion, binding.squareField, viewModel.qnaData(index))

        binding.btnAnswer.setOnClickListener {
            if (!binding.squareField.text.isNullOrEmpty()) {
                if (isAnswerTrue(answer, binding.squareField.text.toString())) {
                    viewModel.point()
                    if(index == viewModel.qnaDataa.size - 1) {
                        index = viewModel.qnaDataa.size - 1
                    } else {
                        index++
                    }
                    answer = setQuestion(binding.tvQuestion, binding.squareField, viewModel.qnaData(index))
                    binding.squareField.setText("")
                    binding.tvFalseAnswer.visibility = View.GONE
                    val mp = MediaPlayer.create(context, R.raw.woow)
                    mp.start()
                    Thread.sleep(500)
                } else {
                    binding.tvFalseAnswer.visibility = View.VISIBLE
                    val mp = MediaPlayer.create(context, R.raw.totet)
                    mp.start()
                }
            }

            if (viewModel.point == viewModel.qnaDataa.size) {
                Navigation.findNavController(view).navigate(R.id.action_gameFragment_to_resultFragment)
            }
        }

        binding.btnGiveUp.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_gameFragment_to_resultFragment)
        }

        // refresh fragment
        var fragment = GameFragment()
        var ft = childFragmentManager.beginTransaction()
        ft.detach(fragment)
        ft.attach(fragment)
        ft.commit()

        return view

    }

    fun setQuestion(textView: TextView, squareField: SquarePinField, questionAndAnswer: QuestionAndAnswer): String {
        textView.text = questionAndAnswer.question
        squareField.numberOfFields = questionAndAnswer.answer.length
        return questionAndAnswer.answer
    }

    private fun isAnswerTrue(string1: String, string2: String): Boolean {
        return (string1.equals(string2, ignoreCase = true))
    }

}