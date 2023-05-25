package com.example.paa

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.paa.GetEmployee

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Find POST Button
        val post = findViewById<Button>(R.id.btnpost)
        post.setOnClickListener {
            //Link to PostEmployee Page/Activity
            val x = Intent(applicationContext, PostEmployee::class.java)
            startActivity(x)
        }//end Listener
        val btnget = findViewById<Button>(R.id.btnget)
        btnget.setOnClickListener{
            val x = Intent(applicationContext,GetEmployee::class.java)
            startActivity(x)
        }
        val btndelete = findViewById<Button>(R.id.btndelete)
        btndelete.setOnClickListener{
            val x = Intent(applicationContext,DeleteEmployee::class.java)
            startActivity(x)
        }
        val btnupdate = findViewById<Button>(R.id.btnput)
        btnupdate.setOnClickListener{
            val x = Intent(applicationContext,PutEmployee::class.java)
            startActivity(x)
        }
        val btnmessages = findViewById<Button>(R.id.btnmessages)
        btnmessages.setOnClickListener{
            Toast.makeText(
                applicationContext,"GET MESSAGES",
            Toast.LENGTH_SHORT
            ).show()

            val x = Intent(applicationContext, btnmessages::class.java)
            startActivity(x)
        }
    }
}
