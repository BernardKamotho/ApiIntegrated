package com.example.paa

import ApiHelper
import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import org.json.JSONArray

class Messages : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_messages)
        class messages : AppCompatActivity() {
            @SuppressLint("MissingInflatedId", "MissingSuperCall")
            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_messages)

                val progress = findViewById<ProgressBar>(R.id.progress)

                //Get api url

                val api = "https://jsonplaceholder.typicode.com/posts"

                //access helper

                val helper = ApiHelper(applicationContext)

                helper.get(api, object : ApiHelper.CallBack {
                    //the input will be saved in result variable
                    override fun onSuccess(result: String?) {
                        // convert the get results to json variable
                        val employeeJSONArray = JSONArray(result.toString())

                        (0 until employeeJSONArray.length()).forEach {
                            val employee = employeeJSONArray.getJSONObject(it)

                            val empmessages = findViewById<Button>(R.id.btnmessages)
                            empmessages.append("userId : " + employee.get("userId") + "\n")
                            empmessages.append("id : " + employee.get("id") + "\n")
                            empmessages.append("title : " + employee.get("title") + "\n")
                            empmessages.append("body : " + employee.get("body") + "\n")
                            empmessages.append("\n\n")
                        }
                        //stop progress
                        progress.visibility = View.GONE
                    }
                })
            }
        }
    }
}


