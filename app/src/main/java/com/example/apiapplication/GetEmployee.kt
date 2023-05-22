package com.example.apiapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import org.json.JSONArray

class GetEmployee : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_employee)
        val progress = findViewById<ProgressBar>(R.id.progress)
        //Base API URL
        val api = "https://modcom.pythonanywhere.com/employees"

        //Access the Helper
        val helper = ApiHelper(applicationContext)
        helper.get(api, object : ApiHelper.CallBack{
            override fun onSuccess(result: String?) {
                //Toast.makeText(applicationContext, ""+result.toString(), Toast.LENGTH_SHORT).show()
                //Convert the GET results to JSON Array
                val employeeJSONArray = JSONArray(result.toString())
                //Toast.makeText(applicationContext, "$employeeJSONArray", Toast.LENGTH_SHORT).show()
                //Loop Each Object in the JSONArray
                (0 until employeeJSONArray.length()).forEach {
                    val employee = employeeJSONArray.getJSONObject(it)
                    //FOr each Object Find the TextView and Append the 5 C0lumns
                    val empdata = findViewById<TextView>(R.id.empdata)
                    empdata.append("ID:"+employee.get("id_number")+"\n")
                    empdata.append("Username:"+employee.get("username")+"\n")
                    empdata.append("Others: "+employee.get("others")+"\n")
                    empdata.append("Salary"+employee.get("salary")+"\n")
                    empdata.append("Dept: "+employee.get("department")+"\n")
                    empdata.append("\n\n")
                    //Since its a Loop, ALl EMployees are Loaded in the TextView.
                }
                //Stop Progress
                progress.visibility = View.GONE
            }
        })
    }//end Oncreate
}//end CLass}