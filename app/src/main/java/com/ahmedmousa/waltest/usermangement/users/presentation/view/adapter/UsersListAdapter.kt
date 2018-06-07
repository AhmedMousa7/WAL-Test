package com.ahmedmousa.waltest.usermangement.users.presentation.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.ahmedmousa.waltest.R
import com.ahmedmousa.waltest.usermangement.base.domain.entity.UserEntity
import com.bumptech.glide.Glide
import de.hdodenhof.circleimageview.CircleImageView
import io.reactivex.subjects.PublishSubject

class UsersListAdapter : RecyclerView.Adapter<UsersListAdapter.UsersListViewHolder>() {

    private var list : List<UserEntity>

    val clickEvent : PublishSubject<UserEntity>  = PublishSubject.create<UserEntity>()

    init {
        list = emptyList()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersListViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val myListItemView =  inflater.inflate(R.layout.view_users_list_item_layout , parent , false)

        return UsersListViewHolder(myListItemView)
    }

    override fun onBindViewHolder(holder: UsersListViewHolder, position: Int) {
        val userInfo : UserEntity = list[position]
        holder.bindView(userInfo)

        //here emits value
        holder.itemView.setOnClickListener {
            clickEvent.onNext(userInfo)
        }
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        super.onDetachedFromRecyclerView(recyclerView)
        clickEvent.onComplete()
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setUsersData(list : List<UserEntity>){
        this.list = list
    }

    class UsersListViewHolder(view : View) : RecyclerView.ViewHolder(view) {

        private val tvUserName : TextView = view.findViewById(R.id.tvUserName)

        private val imgUser : CircleImageView = view.findViewById(R.id.imgUser)

        fun bindView(userInfo: UserEntity) {

            tvUserName.text = userInfo.login

            Glide.with(itemView).load(userInfo.avatar_url).into(imgUser)
        }
    }

}