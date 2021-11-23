package com.alex.arbitrary

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class AboutFragment : Fragment() {

    private lateinit var backButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_about, container, false)
        backButton = view.findViewById(R.id.back_button)
        val aboutFragment = AboutFragment()
        backButton.setOnClickListener {
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(R.id.fragment_container, aboutFragment)
                ?.commit()


        }


        return view


    }
}