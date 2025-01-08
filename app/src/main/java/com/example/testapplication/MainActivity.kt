

package com.example.testapplication

import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private var rollCount = 0 // Counter to track the number of rolls

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val rollButton: Button = findViewById(R.id.buttonRollDice)
        rollButton.setOnClickListener {
            val timer = object: CountDownTimer(1600, 400) { // ms in future, interval ms

                override fun onTick(millisUntilFinished: Long) {
                    val rollButton: Button = findViewById(R.id.buttonRollDice)
                    rollButton.setBackgroundColor(Color.parseColor("#ff0000"))
                    rollDice()
                }

                override fun onFinish() {
                    val rollButton: Button = findViewById(R.id.buttonRollDice)
                    rollButton.setBackgroundColor(Color.parseColor("#0000ff"))
                    rollDice()
                }
            }
            timer.start()
        }

    }

//    private fun rollDice() {
//        rollCount++ // Increment the roll count
//        val dice = Dice(6)
//        val diceRoll = dice.roll()
//
//        val diceRollTextView: TextView = findViewById(R.id.textViewDiceRoll)
//        val messageTextView: TextView = findViewById(R.id.textViewMessage)
//
//        // Update the TextViews
//        diceRollTextView.text = "Tatiana's Dice Game: $diceRoll"
//        messageTextView.text = when (rollCount) {
//            1 -> "You rolled a $diceRoll"
//            2 -> "The dice rolled twice."
//            else -> "The dice rolled $rollCount times."
//        }
//    }


//private fun rollDice() {
//    val dice = Dice(6)
//    val diceRoll = dice.roll()
//
//    val diceRollTextView: TextView = findViewById(R.id.textViewDiceRoll)
//    val messageTextView: TextView = findViewById(R.id.textViewMessage)
//
//    // Update the TextViews
//    diceRollTextView.text = "Tatiana's Dice Game: $diceRoll"
//    messageTextView.text = "You rolled a $diceRoll"
//
//    // Reset the roll count
//    rollCount = 1
//}
//}

    private fun rollDice(): Int {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val diceImage: ImageView = findViewById(R.id.imageView)


        val diceRollTextView: TextView = findViewById(R.id.textViewDiceRoll)
    val messageTextView: TextView = findViewById(R.id.textViewMessage)

    // Update the TextViews
    diceRollTextView.text = "Tatiana's Dice Game: $diceRoll"
    messageTextView.text = "You rolled a $diceRoll"

        if (diceRoll == 1) {
            diceImage.setImageResource(R.drawable.dice_1)
        } else if (diceRoll == 2) {
            diceImage.setImageResource(R.drawable.dice_2)
        } else if (diceRoll == 3) {
            diceImage.setImageResource(R.drawable.dice_3)
        } else if (diceRoll == 4) {
            diceImage.setImageResource(R.drawable.dice_4)
        } else if (diceRoll == 5) {
            diceImage.setImageResource(R.drawable.dice_5)
        } else if (diceRoll == 6) {
            diceImage.setImageResource(R.drawable.dice_6)
        }
        return diceRoll
    }

    class Dice(val numSides: Int) {
        fun roll(): Int {
            return (1..numSides).random()
        }
    }
}

