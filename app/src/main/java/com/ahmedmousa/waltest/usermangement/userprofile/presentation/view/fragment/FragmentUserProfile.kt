package com.ahmedmousa.waltest.usermangement.userprofile.presentation.view.fragment

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.ahmedmousa.waltest.R
import com.ahmedmousa.waltest.base.data.model.MyResponse
import com.ahmedmousa.waltest.base.presentation.view.fragment.FragmentLoading
import com.ahmedmousa.waltest.base.presentation.viewmodel.ViewModelFactory
import com.ahmedmousa.waltest.usermangement.base.domain.entity.UserEntity
import com.ahmedmousa.waltest.usermangement.userprofile.presentation.viewmodel.UserProfileViewModel
import com.bumptech.glide.Glide
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_user_profile_layout.*
import java.io.IOException
import javax.inject.Inject

class FragmentUserProfile : FragmentLoading(){

    @Inject
    lateinit var viewModelFactory: ViewModelFactory<UserProfileViewModel>

    private lateinit var profileViewModel : UserProfileViewModel

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun childFragmentLayoutId(): Int {
        return R.layout.fragment_user_profile_layout
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (arguments == null) return

        val userId : String = arguments!!.getString("userName")

        profileViewModel = ViewModelProviders.of(this , viewModelFactory).get(UserProfileViewModel::class.java)
        profileViewModel.getUser(userId).observe(this ,  Observer<MyResponse<UserEntity>> { myResponse : MyResponse<UserEntity>? ->

            when (myResponse) {

                is MyResponse.Progress -> showLoadingBar(true)

                is MyResponse.Success -> {

                    showLoadingBar(false)

                    showView(true)

                    val userEntity : UserEntity = myResponse.data

                    Glide.with(this).load(userEntity.avatar_url).into(imgUserProfile)

                    tvUserProfileName.text = userEntity.login
                    tvUserProfileUrl.text = userEntity.url
                    tvUserProfileLocation.text = userEntity.location
                }

                is MyResponse.Failure -> {
                    if (myResponse.e is IOException)
                        showError("No internet connection")
                    else
                        showError("Failed try again later")
                }

            }
        })

    }

}