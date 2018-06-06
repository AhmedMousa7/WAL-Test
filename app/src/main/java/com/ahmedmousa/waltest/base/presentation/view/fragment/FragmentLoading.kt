package com.ahmedmousa.waltest.base.presentation.view.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ahmedmousa.waltest.R
import kotlinx.android.synthetic.main.fragment_loading_layout.*

abstract class FragmentLoading : Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_loading_layout , container , false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val childView : View = LayoutInflater.from(activity).inflate(childFragmentLayoutId() , fragmentContainer , false)

        fragmentContainer.addView(childView)
    }

    fun showLoadingBar(isShow : Boolean){

        if (isShow) progressBar.visibility = View.VISIBLE

        else progressBar.visibility = View.GONE
    }

    fun showView(isShow : Boolean){

        if (isShow) fragmentContainer.visibility = View.VISIBLE

        else fragmentContainer.visibility = View.GONE
    }

    fun showError(errorMsg : String){
        showLoadingBar(false)
        showView(false)
        tvError.visibility = View.VISIBLE
        tvError.text = errorMsg
    }

    abstract fun childFragmentLayoutId() : Int
}