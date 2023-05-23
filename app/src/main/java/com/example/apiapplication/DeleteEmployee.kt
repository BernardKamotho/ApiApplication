package com.example.apiapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import org.json.JSONObject

class DeleteEmployee : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delete_employee)

        val id_number = findViewById<EditText>(R.id.Delete_Id)

        val delete =findViewById<Button>(R.id.deletebtn)
        delete.setOnClickListener {
            //get the api
            val api = "https://modcom.pythonanywhere.com/employees"

            //access the helper
            val helper = ApiHelper(applicationContext)

            //have the json object
            val body = JSONObject()

            //hold the id of the employee inside the object
            body.put("id_number", id_number.text.toString())

            //trigger the delete function in the helper class
            helper.delete(api, body)
        }
    }
}