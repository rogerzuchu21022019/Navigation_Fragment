package com.example.myapplication.kotlin.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemRvBinding
import com.example.myapplication.kotlin.database.entities.User

class UserAdapter : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    lateinit var itemRvBinding: ItemRvBinding
    var userList= listOf<User>()
    lateinit var layoutInflater: LayoutInflater
    class UserViewHolder(itemRvBinding: ItemRvBinding) : RecyclerView.ViewHolder(itemRvBinding.root) {

    }
    fun setDataForAdapter(userList: List<User>){
        this.userList=userList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        layoutInflater = LayoutInflater.from(parent.context)
        itemRvBinding = ItemRvBinding.inflate(layoutInflater,parent,false)
        return UserViewHolder(itemRvBinding = itemRvBinding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        var currentUser = userList.get(position)
         itemRvBinding.tvUserName.text = currentUser.account
         itemRvBinding.tvPassWord.text = currentUser.password
    }

    override fun getItemCount(): Int {
        return userList.size
    }


}