package com.example.onactivityresult

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val MY_REQUEST_CODE = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnGotoSecondActivity.setOnClickListener {
            startActivityForResult(
                Intent(this@MainActivity, SecondActivity::class.java),
                MY_REQUEST_CODE
            )
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == MY_REQUEST_CODE && resultCode == RESULT_OK) {
            if (data != null) {
                val bundle = data.extras
                val name = bundle!!.getString("name")
                Toast.makeText(this, name, Toast.LENGTH_SHORT).show()
            }
        }
    }
}