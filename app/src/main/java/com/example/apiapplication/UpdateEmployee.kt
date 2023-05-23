package com.example.apiapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import org.json.JSONObject

class UpdateEmployee : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_employee)

        // get the elements by their ids

        val salary = findViewById<EditText>(R.id.salarytwo)
        val id_number = findViewById<EditText>(R.id.id_numbertwo)
        val btn = findViewById<Button>(R.id.btnupdate)

        btn.setOnClickListener {
            //create a json object that will enable you to hold values from the edit texts
            val body = JSONObject()

            //assing the new values
            body.put("id_number", id_number.text.toString())
            body.put("salary", salary.text.toString())

            //Base API URL
            val api = "https://modcom.pythonanywhere.com/employees"

            //Access the Helper
            val helper = ApiHelper(applicationContext)

            //trigger the put function in the helper class
            helper.put(api, body)
        }



    }
}