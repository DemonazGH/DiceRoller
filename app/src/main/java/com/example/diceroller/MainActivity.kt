package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
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
        rollDice()
        rollDice2()
    }

    private fun rollDice2() {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        //find the ImageView in the layout
        val diceImage = findViewById<ImageView>(R.id.imageView2)
        // determine what drawable resource to use based on the dice roll
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)
        diceImage.contentDescription = diceRoll.toString()
    }

    /**
     * roll the dice and update screen with the result
     */
    private fun rollDice() {
        // create new dice object with 6 sides and roll the dice
        val dice = Dice(6)
        val diceRoll = dice.roll()
        //find the ImageView in the layout
        val diceImage = findViewById<ImageView>(R.id.imageView)
        // determine what drawable resource to use based on the dice roll
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)
        diceImage.contentDescription = diceRoll.toString()
    }
}

class Dice(val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}