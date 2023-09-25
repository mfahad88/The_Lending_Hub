package com.example.thelendinghub.fragment.onboard

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.thelendinghub.R
import com.example.thelendinghub.custom.LargeButton
import com.example.thelendinghub.custom.OnDataPass

/**
 * A simple [Fragment] subclass.
 * Use the [OnBoardFourFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class OnBoardFourFragment : Fragment() {
    lateinit var dataPassListener: OnDataPass
    lateinit var buttonNext: LargeButton
    lateinit var buttonPrevious: LargeButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view=inflater.inflate(R.layout.fragment_on_board_four, container, false)
        initViews(view)
        buttonPrevious.setOnClickListener {
            dataPassListener.onDataPass("three")
        }
        buttonNext.setOnClickListener {
            dataPassListener.onDataPass("register")
        }
        // Inflate the layout for this fragment
        return view
    }

    private fun initViews(view: View) {
        buttonNext=view.findViewById(R.id.buttonNext)
        buttonPrevious=view.findViewById(R.id.buttonPrevious)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            dataPassListener = context as OnDataPass
        } catch (e: ClassCastException) {
            throw ClassCastException("$context must implement OnDataPass")
        }
    }

}