package com.example.paa

import ApiHelper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import com.example.paa.R
import org.json.JSONArray

class GetEmployee : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_employee)

        val progress = findViewById<ProgressBar>(R.id.progress)

        //get api
        val api ="https://modcom.pythonanywhere.com/employees"

        //get api helper
        val helper = ApiHelper(applicationContext)
        helper.get(api, object : ApiHelper.CallBack{
            override fun onSuccess(result: String?) {
                val employeeJSONArray = JSONArray(result.toString())

                (0 until  employeeJSONArray.length()).forEach{
                    val employee = employeeJSONArray.getJSONObject(it)

                    val empdata = findViewById<TextView>(R.id.empdata)
                    empdata.append("ID : "+employee.get("id_number")+"\n")
                    empdata.append("username : "+employee.get("username")+"\n")
                    empdata.append("others : "+employee.get("others")+"\n")
                    empdata.append("salary : "+employee.get("salary")+"\n")
                    empdata.append("department : "+employee.get("department")+"\n")
                    empdata.append("\n\n")
                }
                // stop progress bar
                progress.visibility = View.GONE
            }
        })
    }
}