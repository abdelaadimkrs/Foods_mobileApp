package com.example.android.foodapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_food_details.*

class FoodDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_details)

        val bundle= intent.extras
        val name = bundle!!.getString("name")
        val des = bundle!!.getString("des")
        val img = bundle!!.getInt("img")
        imgv.setImageResource(img)
        titlev.setText(name).toString().trim()
        desv.setText(des).toString().trim()


    }
}