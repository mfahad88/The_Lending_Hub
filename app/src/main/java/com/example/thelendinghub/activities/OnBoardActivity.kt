package com.example.thelendinghub.activities


import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction


import com.example.thelendinghub.R
import com.example.thelendinghub.custom.OnDataPass
import com.example.thelendinghub.fragment.onboard.OnBoardFourFragment
import com.example.thelendinghub.fragment.onboard.OnBoardOneFragment
import com.example.thelendinghub.fragment.onboard.OnBoardThreeFragment
import com.example.thelendinghub.fragment.onboard.OnBoardTwoFragment


class OnBoardActivity : BaseActivity(),OnDataPass{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_board)
        loadFragment(OnBoardOneFragment())

        initViews()
    }

    private fun initViews() {
        val toolbar: Toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
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

    override fun onDataPass(data: String?) {

        if(data.equals("one",true)){
            loadFragment(OnBoardOneFragment())
        } else if(data.equals("two",true)){
            loadFragment(OnBoardTwoFragment())
        } else if(data.equals("three",true)){
            loadFragment(OnBoardThreeFragment())
        }else if(data.equals("four",true)){
            loadFragment(OnBoardFourFragment())
        }else if(data.equals("register",true)){
            finish()
            startActivity(Intent(this,RegisterActivity::class.java))
        }
    }
}