package com.example.bottomnav

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.bottomnav.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(){
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val home1 = homeFragment1()
        val home2 = homeFragment2()
        val home3 = homeFragment3()
        showFragment(home1)
        binding.Nav.run{
            setOnItemSelectedListener { item ->
                when(item.itemId){
                    R.id.home1 -> showFragment(home1)
                    R.id.home2 -> showFragment(home2)
                    R.id.home3 -> showFragment(home3)
                    else -> true
                }
            }
        }

    }

    private fun showFragment(fragment: Fragment): Boolean{
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.container,fragment)
            commit()
        }
        return true
    }
}