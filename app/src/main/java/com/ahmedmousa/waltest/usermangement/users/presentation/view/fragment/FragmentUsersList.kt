package com.ahmedmousa.waltest.usermangement.users.presentation.view.fragment

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.ahmedmousa.waltest.R
import com.ahmedmousa.waltest.base.data.model.MyResponse
import com.ahmedmousa.waltest.base.presentation.view.fragment.FragmentLoading
import com.ahmedmousa.waltest.base.presentation.viewmodel.ViewModelFactory
import com.ahmedmousa.waltest.usermangement.base.presentation.view.listener.OnReplaceFragmentListener
import com.ahmedmousa.waltest.usermangement.base.domain.entity.UserEntity
import com.ahmedmousa.waltest.usermangement.users.presentation.view.adapter.UsersListAdapter
import com.ahmedmousa.waltest.usermangement.users.presentation.viewmodel.UsersListViewModel
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_users_layout.*
import javax.inject.Inject

class FragmentUsersList : FragmentLoading() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory<UsersListViewModel>

    private lateinit var userListViewModel: UsersListViewModel

    private lateinit var onReplaceFragmentListener: OnReplaceFragmentListener

    @Inject
    lateinit var usersListAdapter: UsersListAdapter

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)

        if (context is OnReplaceFragmentListener) onReplaceFragmentListener = context
    }

    override fun childFragmentLayoutId(): Int {
        return R.layout.fragment_users_layout
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rcvUsers.layoutManager = LinearLayoutManager(activity , LinearLayoutManager.VERTICAL , false)
        rcvUsers.adapter = usersListAdapter

        //subscribe to on onClick
        usersListAdapter.clickEvent.subscribe {
            onShowUserProfile(it)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        userListViewModel = ViewModelProviders.of(this , viewModelFactory).get(UsersListViewModel::class.java)
        userListViewModel.getUsersList().observe(this , Observer<MyResponse<List<UserEntity>>> { response : MyResponse<List<UserEntity>>? ->

            when(response){

                is MyResponse.Progress -> showLoadingBar(true)

                is MyResponse.Success ->{

                    showLoadingBar(false)

                    showView(true)

                    //set data
                    usersListAdapter.setUsersData(response.data)
                }

                is MyResponse.Failure -> showError("Error in connection")
            }

        })
    }

    private fun onShowUserProfile(userEntity: UserEntity) {
        val bundle = Bundle()
        bundle.putString("userName" , userEntity.login)
        onReplaceFragmentListener.onOpenDetailsFragment(bundle)
    }
}