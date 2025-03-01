package com.example.project3

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    companion object {
        lateinit var encrypter: Encryption
    }

    //private lateinit var encrypter : Encryption
    private lateinit var enterLabel : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        encrypter = Encryption()
        enterLabel = findViewById<TextView>(R.id.enter_label)
        val userInput = findViewById<EditText>(R.id.enter_box)
        val badInputText = findViewById<TextView>(R.id.bad_input_msg)
        val button = findViewById<Button>(R.id.button)


        //researched how to implement TextChangedListener to hide text box upon user input
        userInput.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, start: Int, count: Int, after: Int) {
                //don't need
            }

            override fun onTextChanged(charSequence: CharSequence, start: Int, before: Int, count: Int) {
                //once user types make textview disappear and center text
                if (charSequence.length > 0) {
                    enterLabel.visibility = View.GONE
                    userInput.gravity = Gravity.CENTER
                } else {
                    enterLabel.visibility = View.VISIBLE
                    userInput.gravity = Gravity.START

                }
            }

            override fun afterTextChanged(editable: Editable) {
                //don't need
            }
        })


        button.setOnClickListener(){

            var input = userInput.text.toString().toInt()
            //Log.w("MainActivity", "$input")
            if(input < 0 || input > 25) {
                badInputText.visibility = View.VISIBLE
            } else {
                encrypter.setShiftInput(input)
                Log.w("MainActivity", "${encrypter.getShift()}")
                /*val word = MainActivity.encrypter.encrypt(input, "HELLO")
                Log.w("MainActivity", "$word")

                 */

                modifyData()
            }
        }
    }

    fun modifyData() {
        var intent = Intent(this, EncryptActivity::class.java)
        startActivity(intent)
    }

    // Modify page, when we come back to this page, we have to show the id:enter_label
    // Also maybe get rid of the text in the Edit
    override fun onResume() {
        super.onResume()

        enterLabel.text = MainActivity.encrypter.getShift().toString()
    }
}