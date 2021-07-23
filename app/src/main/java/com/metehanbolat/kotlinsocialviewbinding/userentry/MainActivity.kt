package com.metehanbolat.kotlinsocialviewbinding.userentry

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation.findNavController
import com.metehanbolat.kotlinsocialviewbinding.R
import com.metehanbolat.kotlinsocialviewbinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val navController = findNavController(this, R.id.fragmentContainerView)

        binding.bottomNavigationView.setOnItemSelectedListener {

            when(it.itemId){

                R.id.signInFragment -> {
                    if (navController.currentDestination.toString() != "Destination(com.metehanbolat.kotlinsocialviewbinding:id/signInFragment) label=fragment_sign_in class=com.metehanbolat.kotlinsocialviewbinding.userentry.SignInFragment"){
                        navController.navigate(R.id.action_signUpFragment_to_signInFragment)
                    }
                }
                R.id.signUpFragment ->{
                    if (navController.currentDestination.toString() != "Destination(com.metehanbolat.kotlinsocialviewbinding:id/signUpFragment) label=fragment_sign_up class=com.metehanbolat.kotlinsocialviewbinding.userentry.SignUpFragment"){
                        navController.navigate(R.id.action_signInFragment_to_signUpFragment)
                    }
                }
            }
            true
        }
    }
}