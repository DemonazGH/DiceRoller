package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton = findViewById<Button>(R.id.button)
        rollButton.setOnClickListener {
            rollDice()
            rollDice2()
        }
    }

    private fun rollDice2() {
        val dice = Dice(6)
        dice.roll()
        // updates screen with the result
        val resultTextView = findViewById<TextView>(R.id.textView2)
        resultTextView.text = dice.roll().toString()
    }


    /**
     * roll the dice and update screen with the result
     */
    private fun rollDice() {
        // create new dice object
        val dice = Dice(6)
        dice.roll()
        // updates screen with the result
        val resultTextView = findViewById<TextView>(R.id.textView)
        resultTextView.text = dice.roll().toString()
    }
}

class Dice(val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}