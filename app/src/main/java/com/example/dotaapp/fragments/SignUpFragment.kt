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
import com.example.dotaapp.databinding.FragmentSignUpBinding
import com.example.dotaapp.model.User


class SignUpFragment : Fragment() {

    private var _binding: FragmentSignUpBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnRegister.setOnClickListener {
            val name = binding.edtNameReg.editText?.text
            val password = binding.edtPassReg.editText?.text
            val passwordConfirm = binding.edtConfirmPassReg.editText?.text
            val user = User(name.toString(), password.toString(), passwordConfirm.toString())
            if (verifyInputs(user)) {
                val newPref: SharedPreferences = requireActivity().getSharedPreferences(
                    "data_pref",
                    MODE_PRIVATE
                )
                val editor = newPref
                    .edit()
                    .putString("name", user.name)
                    .putString("password", user.password)
                editor.apply()
                findNavController().popBackStack()
            }
        }
    }

    private fun verifyInputs(u: User): Boolean {

        var flag: Boolean = false
        if (u.name == "") {
            alert(requireContext(), "nombre requerido")
            /*alert(this, "nombre requerido")*/
        } else if (u.password == "") {
            alert(requireContext(), "password requerido")
        } else if (u.passConfirm == "") {
            alert(requireContext(), "confirmar password")
        } else if (u.password != u.passConfirm) {
            alert(requireContext(), "las password no coinciden")
        } else {
            flag = true
        }
        return flag
    }

    private fun alert(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}




