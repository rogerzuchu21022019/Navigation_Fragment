package com.example.myapplication.kotlin.fragments.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentHomeBinding
import com.example.myapplication.kotlin.adapters.UserAdapter
import com.example.myapplication.kotlin.viewmodel.UserViewModel

class HomeFragment : Fragment(), View.OnClickListener {
    var homeBinding: FragmentHomeBinding? = null
    lateinit var adapter:UserAdapter
    lateinit var userViewModel: UserViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeBinding = FragmentHomeBinding.inflate(layoutInflater)
        initViewModel()
        initRecycleView()
        initButton()
        return homeBinding!!.root
    }

    private fun initViewModel() {
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        userViewModel.getAllInformation.observe(viewLifecycleOwner) { userList ->
            adapter.setDataForAdapter(userList = userList)
        }
    }

    private fun initRecycleView() {
        adapter = UserAdapter()
        homeBinding?.rv?.adapter =adapter

    }

    private fun initButton() {
        homeBinding?.fabAdd?.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_registerFM)
        }
        homeBinding?.fabDelete?.setOnClickListener{
            userViewModel.deleteAll()
        }
    }

    override fun onClick(p0: View?) {

    }
}