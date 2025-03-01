package com.example.project3

import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class EncryptActivity: AppCompatActivity() {

    /*
    val userInput = findViewById<EditText>(R.id.enter_string)
    val shift = findViewById<TextView>(R.id.shift_label)
    val result = findViewById<TextView>(R.id.encryption_result)
    val encryptButton = findViewById<Button>(R.id.encryptButton)
    */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        setContentView(R.layout.activity_encrypt)
        var userInput = findViewById<EditText>(R.id.enter_string)
        //userInput.setShowSoftInputOnFocus(false)
        //getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        // Prevents keyboard from popping up when EditText is clicked
        userInput.setInputType(InputType.TYPE_NULL);

        var underline = findViewById<View>(R.id.underline)
        underline.visibility = View.GONE
        var shift = findViewById<TextView>(R.id.shift_label)
        var result = findViewById<TextView>(R.id.encryption_result)
        var encryptButton = findViewById<Button>(R.id.encryptButton)


        // Displays the shift value
        val shiftNum = MainActivity.encrypter.getShift()
        shift.text = "Shift = " + shiftNum.toString()

        userInput.setOnFocusChangeListener { view, hasFocus ->
            if (hasFocus && userInput.text.toString() == "-") {
                userInput.text.clear()
                underline.visibility = View.VISIBLE
            } else {

            }
        }

        encryptButton.setOnClickListener {
            val text = userInput.text.toString()
            // Displays the word after encryption
            /*
            Log.w("MainActivity", "EditText input was $text")
            val word = MainActivity.encrypter.encrypt(shiftNum, text)
            Log.w("MainActivity", "Encrypted is $word")
             */
            result.text = MainActivity.encrypter.encrypt(shiftNum, text)
        }


        var goBackButton : Button = findViewById<Button>( R.id.goBackButton )
        goBackButton.setOnClickListener { goBack() }

    }


    fun goBack( ) {
        finish( )  // this.finish( )
    }
}