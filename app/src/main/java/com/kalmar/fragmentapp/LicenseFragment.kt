package com.kalmar.fragmentapp

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment


class LicenseFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_license, container, false)
        val licenseTextView:TextView = view.findViewById(R.id.license_text_view)
//        licenseTextView.movementMethod = ScrollingMovementMethod()
        licenseTextView.text = activity?.assets
            ?.open("license.txt")
            ?.bufferedReader().use { it?.readText()!! }

        return view
    }

}