package com.example.project3

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

class EncryptActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_encrypt)

        val encryptor = Encryption()

        val enterLabel = findViewById<TextView>(R.id.enter_label)
        val userInput = findViewById<EditText>(R.id.enter_box)
        val shiftNum = findViewById<TextView>(R.id.shift_equals)
        val shifted = findViewById<TextView>(R.id.shifted)
        val encryptButton = findViewById<Button>(R.id.encrypt_button)
        val backButton = findViewById<Button>(R.id.back_button)


        userInput.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, start: Int, count: Int, after: Int) {
                //don't need
            }

            override fun onTextChanged(charSequence: CharSequence, start: Int, before: Int, count: Int) {
                //once user types make textview disappear and center text
                if (charSequence.length > 0) {
                    enterLabel.visibility = View.INVISIBLE
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

        encryptButton.setOnClickListener() {
            encryptor.setShiftInput(MainActivity.shiftNum)
        }

        backButton.setOnClickListener() {

        }


    }
}