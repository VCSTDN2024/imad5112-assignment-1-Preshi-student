    package vcmsa.ci.mealplanner

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private var mealText: EditText? = null
    private var display: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        setContentView(R.layout.activity_main)

        //  Input UI Elements
        mealText = findViewById(R.id.mealText)
        display = findViewById(R.id.display)

        val suggestBtn = findViewById<Button>(R.id.suggestBtn)
        val resetBtn = findViewById<Button>(R.id.resetBtn)
        // Input reset button to clear data after user has inputted meal suggestions
        resetBtn.setOnClickListener {
            mealText?.text?.clear()  // Clear field that the user enters in UI elements
            display?.text = ""   // Clear field that the user enters in UI elements
        }

        // Meal suggestions are inputted when user clicks on the button
        suggestBtn.setOnClickListener {
            inputGenerate()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets


        }
    }

    private fun inputGenerate() {
        val inputText = mealText?.text.toString()?.trim()?.lowercase() ?: ""
        var output = ""



        if (inputText == "morning") {
            output = "Cheese and mayo, hot chocolate"

        } else if (inputText == "afternoon") {
            output = "Bacon and cheese burger,butternut and veggies,sprite"

        } else if (inputText == "dinner") {
            output = "Nachos,Chips and Chicken strips,pasta,water"

        } else {
            output = "Invalid input"

        }

        // Display meal suggestions
        display?.text = output
    }
}