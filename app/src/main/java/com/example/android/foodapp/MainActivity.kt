package com.example.android.foodapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_of_list.view.*

class MainActivity : AppCompatActivity() {
    var listOfFood = ArrayList<Food>()
    var adapter:FoodAdapter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        LoadFood()
        adapter = FoodAdapter(listOfFood,this)
        lvfood.adapter=adapter

    }

    fun LoadFood()
    {
        listOfFood.add(Food("How to make crunchy potatoes","Put the potatoes in hot oil in a frying pan on the fire ,Leave it on the fire until it turns red and gets a golden color.",R.drawable.im1))
        listOfFood.add(Food("How to prepare the Dar Bread","Put the flour in a deep bowl, then make a hole in the middle, then add the yeast, salt, milk and oil. Mix the ingredients together until they are mixed, then start adding water gradually while kneading.",R.drawable.im2))
        listOfFood.add(Food("How to prepare the whale tagine","Put all of: lemon juice, parsley, olive oil, coriander, garlic, cumin, paprika, black pepper and salt in a large bowl, and mix all the ingredients well. Grease the fish inside and outside with the mixture of ingredients, using a kitchen brush, and spread the vegetables with the same mixture. Put the fish in an oven tray with the vegetables.",R.drawable.im3))
        listOfFood.add(Food("How To Make Burgers on the Stovetop","Maybe even more than the fat content or the quality of the beef, I’ve found that using a light touch is the real difference between a burger I relish eating and one that becomes tough. The more you handle and mash the beef as you shape the patties, the more compressed and tough the finished burger. Put the fish in an oven tray with the vegetables.",R.drawable.im4))
        listOfFood.add(Food("How To Make tajin ","Maybe even more than the fat content or the quality of the beef, I’ve found that using a light touch is the real difference between a burger I relish eating and one that becomes tough. The more yor. Put the fish in an oven tray with the vegetables.",R.drawable.im5))
    }
    
    class FoodAdapter:BaseAdapter{

        var context :Context?=null
        var listOfFoodLocal = ArrayList<Food>()
        constructor(listOfFood:ArrayList<Food>,context: Context){
            listOfFoodLocal=listOfFood
            this.context=context
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var food = listOfFoodLocal[p0]

            var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE)as LayoutInflater
            val foodView = inflator.inflate(R.layout.item_of_list,null)
            foodView.title.text=food.title!!
            foodView.desc.text=food.des!!
            foodView.img.setImageResource(food.image!!)
            foodView.img.setOnClickListener {
                val intent = Intent(context,FoodDetails::class.java)
                intent.putExtra("name",food.title!!)
                intent.putExtra("des",food.des!!)
                intent.putExtra("img",food.image!!)
                context!!.startActivity(intent)
            }
            return foodView
        }

        override fun getItem(p0: Int): Any {
            return listOfFoodLocal[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getCount(): Int {
            return  listOfFoodLocal.size
        }

    }
}