package com.ahmedmousa.waltest.usermangement.base.presentation.view.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import com.ahmedmousa.waltest.R
import com.ahmedmousa.waltest.usermangement.base.presentation.view.listener.OnReplaceFragmentListener
import com.ahmedmousa.waltest.usermangement.userprofile.presentation.view.fragment.FragmentUserProfile
import com.ahmedmousa.waltest.usermangement.users.presentation.view.fragment.FragmentUsersList
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : AppCompatActivity() , OnReplaceFragmentListener {


    @Inject
    lateinit var fragmentUsersList: FragmentUsersList

    @Inject
    lateinit var fragmentUserProfile: FragmentUserProfile

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AndroidInjection.inject(this)

        setContentView(R.layout.activity_main)

        if (savedInstanceState != null)
            return

        //adding list fragment
        onReplaceFragment(fragmentUsersList , false)
    }

     private fun onReplaceFragment(fragment: Fragment , addToBackStack: Boolean) {
        val fragmentTrans : FragmentTransaction = supportFragmentManager.beginTransaction()

         if (addToBackStack)
             fragmentTrans.addToBackStack(fragment.javaClass.simpleName)

        fragmentTrans.replace(R.id.frameFragmentContainers , fragment).commit()
    }

    override fun onOpenDetailsFragment(bundle: Bundle) {
        fragmentUserProfile.arguments = bundle
        onReplaceFragment(fragmentUserProfile , true)
    }
}
