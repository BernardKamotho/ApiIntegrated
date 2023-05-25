package com.example.paa

import ApiHelper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Button
import org.json.JSONObject

class PostEmployee : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_employee)



        val id_number = findViewById<EditText>(R.id.id_number)
        val username = findViewById<EditText>(R.id.username)
        val others = findViewById<EditText>(R.id.others)
        val salary = findViewById<EditText>(R.id.salary)
        val department = findViewById<EditText>(R.id.department)
        val btnsave = findViewById<Button>(R.id.btnsave )

        btnsave.setOnClickListener {
            //create a json object on a val body that will hold input values from edit texts
            val body = JSONObject()
            body.put("id_number",id_number.text.toString())
            body.put("username",username.text.toString())
            body.put("others",others.text.toString())
            body.put("salary",salary.text.toString())
            body.put("department",department.text.toString())

            //api url
            val api = "http://modcom.pythonanywhere.com/employees"

            //access helper
            val helper = ApiHelper(applicationContext)

            //trigger the post function in helper class
            //we provide the api link and data body
            helper.post(api,body)
        }
    }
}
