package com.metehanbolat.kotlinsocialviewbinding.userinterface

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import com.metehanbolat.kotlinsocialviewbinding.R
import com.metehanbolat.kotlinsocialviewbinding.databinding.ActivityInterfaceBinding

class InterfaceActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInterfaceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInterfaceBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val navController = Navigation.findNavController(this, R.id.fragmentContainerView2)

        binding.bottomNavigationViewInterface.setOnItemSelectedListener {

            when(it.itemId){

                R.id.feedFragment -> {
                    if (navController.currentDestination.toString() == "Destination(com.metehanbolat.kotlinsocialviewbinding:id/profileFragment) label=fragment_profile class=com.metehanbolat.kotlinsocialviewbinding.userinterface.ProfileFragment"){
                        navController.navigate(R.id.action_profileFragment_to_feedFragment)
                    }else if (navController.currentDestination.toString() == "Destination(com.metehanbolat.kotlinsocialviewbinding:id/uploadFragment) label=fragment_upload class=com.metehanbolat.kotlinsocialviewbinding.userinterface.UploadFragment"){
                        navController.navigate(R.id.action_uploadFragment_to_feedFragment)
                    }
                }
                R.id.profileFragment ->{
                    if (navController.currentDestination.toString() == "Destination(com.metehanbolat.kotlinsocialviewbinding:id/feedFragment) label=fragment_feed class=com.metehanbolat.kotlinsocialviewbinding.userinterface.FeedFragment"){
                        navController.navigate(R.id.action_feedFragment_to_profileFragment)
                    }else if (navController.currentDestination.toString() == "Destination(com.metehanbolat.kotlinsocialviewbinding:id/uploadFragment) label=fragment_upload class=com.metehanbolat.kotlinsocialviewbinding.userinterface.UploadFragment"){
                        navController.navigate(R.id.action_uploadFragment_to_profileFragment)
                    }
                }
            }
            true
        }

        binding.uploadButton.setOnClickListener {
            if(navController.currentDestination.toString() == "Destination(com.metehanbolat.kotlinsocialviewbinding:id/profileFragment) label=fragment_profile class=com.metehanbolat.kotlinsocialviewbinding.userinterface.ProfileFragment"){
                navController.navigate(R.id.action_profileFragment_to_uploadFragment)
            }else if (navController.currentDestination.toString() == "Destination(com.metehanbolat.kotlinsocialviewbinding:id/feedFragment) label=fragment_feed class=com.metehanbolat.kotlinsocialviewbinding.userinterface.FeedFragment"){
                navController.navigate(R.id.action_feedFragment_to_uploadFragment)
            }
        }
    }
}