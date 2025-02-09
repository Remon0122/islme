package com.example.islme.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.islme.R
import com.example.islme.databinding.ActivityMainBinding
import com.example.islme.home.hadeth.HadethFragment
import com.example.islme.home.quran.QuranFragment
import com.example.islme.home.sapha.SaphaFragment
import com.example.islme.home.radio.radioFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bottomNavView.setOnItemSelectedListener { menuItem ->
            val fragment : Fragment = when(menuItem.itemId){
                R.id.navigation_quran ->{
                    QuranFragment()
                }
                R.id.navigation_hadeth ->{
                    HadethFragment()
                }
                R.id.navigation_sapha ->{
                    SaphaFragment()
                }
                R.id.navigation_radio ->{
                    radioFragment()
                }
                else->{
                    radioFragment()
                }
            }
            showFragment(fragment)
            return@setOnItemSelectedListener true
        }
    }
    fun showFragment(fragment : Fragment){
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container,fragment).commit()
    }
}