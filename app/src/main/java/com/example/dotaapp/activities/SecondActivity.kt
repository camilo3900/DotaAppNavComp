package com.example.dotaapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.Navigation
import com.example.dotaapp.MainActivity
import com.example.dotaapp.R
import com.example.dotaapp.databinding.ActivitySecondBinding
import com.example.dotaapp.fragments.RegionsFragment

class SecondActivity : AppCompatActivity() {
    private var binding: ActivitySecondBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        setSupportActionBar(binding?.toolbar)
        if(savedInstanceState != null){
            supportFragmentManager.beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.containerSecond, RegionsFragment::class.java, null, "REGION")
                .addToBackStack("")
                .commit()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
         menuInflater.inflate(R.menu.main_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when(item.itemId){
            R.id.returnLogin->{
                finish()//ends the secondActivity and returns MainActivity (Login screen)
                true
            }
            else->{
                super.onOptionsItemSelected(item)
            }
        }

    }


}