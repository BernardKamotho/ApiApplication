package com.example.apiapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import org.json.JSONObject

class Post_page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_page)

        // find all the edit texts and the one button
        val id_number = findViewById<EditText>(R.id.identity_place)
        val username = findViewById<EditText>(R.id.name_place)
        val others = findViewById<EditText>(R.id.others_place)
        val salary = findViewById<EditText>(R.id.salary)
        val department = findViewById<EditText>(R.id.department)
        val btnsave = findViewById<Button>(R.id.btnsave)
        btnsave.setOnClickListener {

        // create a json object that will enable you to hold values from the edit texts
        val body = JSONObject()

        // next is to add the id number, username, others, salary and department to the json object that you had created
        body.put("id_number", id_number.text.toString())
        body.put("username", username.text.toString())
        body.put("others", others.text.toString())
        body.put("salary", salary.text.toString())
        body.put("department", department.text.toString())

        // add the url where you gonna be posting all the staffs
        val api = "https://modcom.pythonanywhere.com/employees"

        // access the helper
        val helper = ApiHelper(applicationContext)

        // trigger the post function in the helper class
        // the post function will require the api and the data body, therefore pass them as required
        helper.post(api,body)

        //done with the implementation

    }
    }
}