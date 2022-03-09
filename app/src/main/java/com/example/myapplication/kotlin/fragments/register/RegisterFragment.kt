package com.example.myapplication.kotlin.fragments.register

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentRegisterBinding
import com.example.myapplication.kotlin.database.entities.User
import com.example.myapplication.kotlin.viewmodel.UserViewModel
import java.util.*

class RegisterFragment : Fragment() {
    lateinit var addBinding: FragmentRegisterBinding
    var userViewModel: UserViewModel? = null
    lateinit var navController: NavController
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        addBinding = FragmentRegisterBinding.inflate(layoutInflater)
        return addBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initViewModel()
        initButton()
    }
    private fun initViewModel() {
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
    }

    private fun initButton() {
        addBinding.btnRegister.setOnClickListener {
            insertNewUserInRecyclerView()
        }
    }

    private fun insertNewUserInRecyclerView() {
        var userName = addBinding.edtUserName.text.toString()
        var password = addBinding.edtPassword.text.toString()

        if (checkInput(userName, password)) {
            val user: User = User(0, userName, password)
            userViewModel?.insertNewUserInRecyclerView(user)
            Toast.makeText(requireContext(), "Register Succesfully", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_registerFM_to_signInFM)
        } else {
            Toast.makeText(requireContext(), "Register Faild", Toast.LENGTH_SHORT).show()
        }
    }

    private fun checkInput(userName: String, password: String): Boolean {
        return !(TextUtils.isEmpty(userName) || TextUtils.isEmpty(password))
    }


}