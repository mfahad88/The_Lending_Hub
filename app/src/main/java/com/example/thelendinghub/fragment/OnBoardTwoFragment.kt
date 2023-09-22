package com.example.thelendinghub.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.thelendinghub.R
import com.example.thelendinghub.custom.LargeButton
import com.example.thelendinghub.custom.OnDataPass

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [OnBoardTwoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class OnBoardTwoFragment : Fragment() {
    lateinit var dataPassListener: OnDataPass
    lateinit var buttonNext:LargeButton
    lateinit var buttonPrevious:LargeButton
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view=inflater.inflate(R.layout.fragment_on_board_two, container, false)
        initViews(view)
        buttonPrevious.setOnClickListener {
            dataPassListener.onDataPass("one")
        }
        buttonNext.setOnClickListener {
            dataPassListener.onDataPass("three")
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