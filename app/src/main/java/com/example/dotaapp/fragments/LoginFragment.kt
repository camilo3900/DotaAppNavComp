package com.example.dotaapp.fragments


import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.dotaapp.R
import com.example.dotaapp.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val preferences: SharedPreferences = requireActivity()
            .getSharedPreferences("data_pref", MODE_PRIVATE)
        val prefName = preferences.getString("name","")?: ""
        val prefPassword = preferences.getString("password", "")?:""
        confirmPref(prefName, prefPassword)//Se verrifica existencia de preferences

        binding.btnIngresar.setOnClickListener {
            val userName = binding.edtUserNameLog.editText?.text
            val userPass = binding.edtUserPassLog.editText?.text
            
            if(verifyInputs(userName.toString(), userPass.toString())) {
                if((userName.toString() == prefName) && (userPass.toString() == prefPassword) ){
                    binding.edtUserNameLog.editText?.setText("")
                    binding.edtUserPassLog.editText?.setText("")
                    findNavController().navigate(R.id.action_loginFragment_to_secondActivity)
                }else{
                    alert( requireContext(),"User not found!")
                }
            }
        }

    }
    private fun verifyInputs(name: String, pass: String): Boolean {
        var flag: Boolean = false
        if(name.isEmpty() && pass.isEmpty()){
            alert(requireContext(),"Required fields")
        }else if(name == ""){
            alert(requireContext(), "Name is required")
        }else if(pass == ""){
            alert( requireContext(),"Password is required")
        }else{
            flag = true
        }
        return flag

    }

    private fun alert(context: Context, mensaje: String) {
        Toast.makeText(context, mensaje, Toast.LENGTH_SHORT).show()
    }

    private fun confirmPref(prefNombre: String, prefPassword: String) {
        if(prefNombre == "" && prefPassword == ""){
            alert(requireContext(),"Required fields")
            findNavController().navigate(R.id.action_loginFragment_to_signUpFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}