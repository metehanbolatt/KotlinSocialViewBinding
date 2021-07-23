package com.metehanbolat.kotlinsocialviewbinding.userentry

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.metehanbolat.kotlinsocialviewbinding.databinding.FragmentSignInBinding
import com.metehanbolat.kotlinsocialviewbinding.userinterface.InterfaceActivity

class SignInFragment : Fragment() {

    private var _binding: FragmentSignInBinding? = null
    private val binding get() = _binding!!

    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSignInBinding.inflate(inflater, container, false)
        val view = binding.root

        auth = Firebase.auth
        val currentUser = auth.currentUser

        if (currentUser != null){
            val intent = Intent(requireContext(),InterfaceActivity::class.java)
            startActivity(intent)
            activity?.finish()
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.signInButton.setOnClickListener {
            val email = binding.signInEmailText.text.toString()
            val password = binding.signInPasswordText.text.toString()

            if (email.isEmpty() || password.isEmpty()){
                Toast.makeText(requireContext(),"Check your email and password!!",Toast.LENGTH_SHORT).show()
            }else{
                auth.signInWithEmailAndPassword(email, password).addOnSuccessListener {
                    val intent = Intent(requireContext(),InterfaceActivity::class.java)
                    startActivity(intent)
                    activity?.finish()
                }.addOnFailureListener {
                    Toast.makeText(requireContext(),it.localizedMessage,Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}