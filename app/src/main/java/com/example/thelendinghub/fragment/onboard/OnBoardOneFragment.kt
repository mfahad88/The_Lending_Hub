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
 * Use the [OnBoardOneFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class OnBoardOneFragment : Fragment() {
    lateinit var buttonPrim: LargeButton
    lateinit var dataPassListener: OnDataPass
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view=inflater.inflate(R.layout.fragment_on_board_one, container, false)
        initViews(view)
        buttonPrim.setOnClickListener{
            dataPassListener.onDataPass("two")
        }
        return view
    }

    private fun initViews(view: View) {
        buttonPrim=view.findViewById<LargeButton>(R.id.button_prim)
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