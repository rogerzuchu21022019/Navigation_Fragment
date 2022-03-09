package com.example.myapplication.kotlin.fragments.signin

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentSigninBinding
import com.example.myapplication.kotlin.database.UserDB
import com.example.myapplication.kotlin.database.entities.User
import com.example.myapplication.kotlin.viewmodel.UserViewModel

class SignInFM : Fragment() {
    var bindingSignin: FragmentSigninBinding? = null

    //    private val args by navArgs<SignInFMArgs>()
    lateinit var userViewModel: UserViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingSignin = FragmentSigninBinding.inflate(inflater, container, false)
        return bindingSignin!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initViewModel()
        initButton()
    }

    private fun initViewModel() {
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

    }

    private fun initButton() {
        bindingSignin?.btnSignIn?.setOnClickListener {
//            findNavController().navigate(R.id.action_signInFM_to_homeFragment)

            getDataFromEditext()
        }
    }

    private fun getDataFromEditext() {
        var isFlag:Boolean?=null
        var userName = bindingSignin?.edtUserNameSignIn?.text.toString()
        var password = bindingSignin?.edtPasswordSignIn?.text.toString()
        userViewModel.getAllInformation.observe(viewLifecycleOwner) { userList ->
            if (!checkInput(userName = userName, password = password)){
                Toast.makeText(requireContext(),"Please press input",Toast.LENGTH_SHORT ).show()
            }
            for (use in userList) {
                if (userName.equals(use.account) && password.equals(use.password)) {
                    isFlag=true
                    Toast.makeText(requireContext(),"Sign in Succesfully",Toast.LENGTH_SHORT ).show()
                    findNavController().navigate(R.id.action_signInFM_to_homeFragment)
                }else{
                    isFlag=false
                }
            }
            if (isFlag==false){
                Toast.makeText(requireContext(),"Username or password is wrong",Toast.LENGTH_SHORT ).show()
            }

        }
    }

    private fun checkInput(userName: String, password: String): Boolean {
        return !(TextUtils.isEmpty(userName) || TextUtils.isEmpty(password))
    }

}