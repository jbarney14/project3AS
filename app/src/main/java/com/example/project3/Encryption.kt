package com.example.project3

class Encryption {

    private var shiftInput = 0
    private var strInput = ""


    fun setShiftInput(input: Int) {
        this.shiftInput = input
    }
    fun setStrInput(input: String) {
        this.strInput = input
    }

    fun getShift(): Int {
        return shiftInput
    }
    fun getStr(): String {
        return strInput
    }


    fun encrypt(shift: Int, str: String) : String {
        var index = 0
        var result = ""
        var charArray = str.toCharArray()


       while (index < charArray.size) {

           var shifts = shift
           while (shifts > 0 && index < charArray.size) {

               // Reached
               if (charArray[index].toInt() == 90) {
                   charArray[index] = 'A'
               } else {
                   charArray[index] = (charArray[index].code + 1).toChar()
               }

               shifts -= 1
           }
           index += 1
       }

        result = String(charArray)
        return result
    }



}