package com.example.thelendinghub.fragment.register

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.thelendinghub.R
import com.example.thelendinghub.custom.LargeButton
import com.example.thelendinghub.custom.OnDataPass


class RegisterOneFragment : Fragment() {


    lateinit var constraintBorrower:ConstraintLayout
    lateinit var constraintLender:ConstraintLayout
    lateinit var buttonProceed:LargeButton
    lateinit var dataPassListener: OnDataPass
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view=inflater.inflate(R.layout.fragment_register_one, container, false)
        initViews(view)
        constraintBorrower.isSelected=true
        constraintLender.setOnClickListener {
            constraintLender.isSelected=true
            constraintBorrower.isSelected=false
        }

        constraintBorrower.setOnClickListener {
            constraintBorrower.isSelected=true
            constraintLender.isSelected=false
        }
        buttonProceed.setOnClickListener { dataPassListener.onDataPass("two") }
        return view
    }

    private fun initViews(view: View) {
        constraintBorrower=view.findViewById(R.id.constraintBorrower)
        constraintLender=view.findViewById(R.id.constraintLender)
        buttonProceed=view.findViewById(R.id.buttonProceed)
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