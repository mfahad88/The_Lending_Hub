package com.example.thelendinghub.activities

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.thelendinghub.R
import com.example.thelendinghub.fragment.register.RegisterOneFragment

class RegisterActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        loadFragment(RegisterOneFragment())
    }

    private fun loadFragment(fragment: Fragment) {
// create a FragmentManager
        val fm: FragmentManager? = supportFragmentManager
        // create a FragmentTransaction to begin the transaction and replace the Fragment
        val fragmentTransaction: FragmentTransaction? = fm?.beginTransaction()
        // replace the FrameLayout with new Fragment
        fragmentTransaction?.replace(R.id.frameLayout, fragment)
        fragmentTransaction?.commit() // save the changes
    }
}