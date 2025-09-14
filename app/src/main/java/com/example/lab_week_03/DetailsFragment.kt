package com.example.lab_week_03

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class DetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val coffeeTitle = view.findViewById<TextView>(R.id.coffeeTitle)
        val coffeeDescription = view.findViewById<TextView>(R.id.coffeeDescription)
        val backButton = view.findViewById<Button>(R.id.backButton)

        val coffeeId = arguments?.getInt(ListFragment.COFFEE_ID)

        // Dummy data
        val coffeeData = mapOf(
            R.id.affogato to Pair("Affogato", "Espresso dituang di atas es krim vanilla."),
            R.id.americano to Pair("Americano", "Espresso dengan tambahan air panas."),
            R.id.latte to Pair("Latte", "Espresso dengan susu steamed."),
            R.id.cappuccino to Pair("Cappuccino", "Espresso dengan foam susu."),
            R.id.mocha to Pair("Mocha", "Espresso dengan cokelat dan susu.")
        )

        val data = coffeeData[coffeeId]
        if (data != null) {
            coffeeTitle.text = data.first
            coffeeDescription.text = data.second
        }

        backButton.setOnClickListener {
            findNavController().popBackStack() // kembali ke ListFragment
        }
    }
}
