package com.example.paa

import ApiHelper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import org.json.JSONObject

class DeleteEmployee : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delete_employee)
        // find the two edit texts and 1 button
        val id_number = findViewById<EditText>(R.id.id_number)
        val btndelete = findViewById<Button>(R.id.btndelete)
        btndelete.setOnClickListener{
            // create ajson object of inputs from the edittexts
            val body = JSONObject()
            body.put("id_number",id_number.text.toString())
            //get api url
            val api = "https://modcom.pythonanywhere.com/employees"

            //get ApiHelper
            val helper = ApiHelper(applicationContext)

            // trigger the put/update function in the helper class
            //in the put function we pass api and the api and json body =as parameters
            helper.put(api,body)
        }
    }
}