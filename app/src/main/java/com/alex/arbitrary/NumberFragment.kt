package com.alex.arbitrary

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

private const val LAST_RANDOMIZED_VALUES = "LAST_RANDOMIZED_VALUES"

class NumberFragment : Fragment() {

    private lateinit var resultTextView: TextView
    private lateinit var randomizeButton: Button

    private var randomValue: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_number, container, false)
        resultTextView = view.findViewById(R.id.result_text_view)
        randomizeButton = view.findViewById(R.id.randomize_button)

        if (savedInstanceState != null)
            resultTextView.text = savedInstanceState.getInt(LAST_RANDOMIZED_VALUES).toString()

        else
            randomize()

        randomizeButton.setOnClickListener { randomize() }


        return view
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(LAST_RANDOMIZED_VALUES, randomValue)
        super.onSaveInstanceState(outState)
    }

        private fun randomize() {
        randomValue = Random.nextInt(100)
        resultTextView.text = randomValue.toString()

    }

}
