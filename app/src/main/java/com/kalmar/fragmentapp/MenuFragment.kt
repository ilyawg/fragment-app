package com.kalmar.fragmentapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment

class MenuFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_menu, container, false)
        val button: Button = view.findViewById(R.id.very_important_button)

        button.setOnClickListener {
            Toast.makeText(activity, "button pressed", Toast.LENGTH_SHORT).show()
        }
        return view
    }
}