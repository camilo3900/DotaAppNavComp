package com.example.dotaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dotaapp.fragments.LoginFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*Init the fragment instance and lift the loginFragment*/
        if(savedInstanceState != null){
            supportFragmentManager.beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.containerLogin, LoginFragment::class.java, null, "LOGIN")
                .addToBackStack("") //Stack the login fragment
                .commit()
        }
    }
}