package com.example.thelendinghub.fragment.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import com.example.thelendinghub.R


class RegisterOneFragment : Fragment() {


    lateinit var cardBorrower:CardView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view=inflater.inflate(R.layout.fragment_register_one, container, false)
        initViews(view)
        cardBorrower.isSelected=false
        return view
    }

    private fun initViews(view: View) {
        cardBorrower=view.findViewById(R.id.cardBorrower)
    }

}