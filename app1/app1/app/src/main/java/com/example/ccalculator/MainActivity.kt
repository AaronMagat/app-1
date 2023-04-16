package com.example.ccalculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    //creating arrays for the spinners options
    val dropdownlist1= arrayOf("Meat", "Seafood", "Vegetarian")
    val dropdownlist2= arrayOf("Dry Heat", "Moist Heat")

    @SuppressLint("SetTextI18n", "UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //creating adapters value for the view purposes
        val adapter= ArrayAdapter(this, android.R.layout.simple_spinner_item, dropdownlist1)
        val adapter2= ArrayAdapter(this, android.R.layout.simple_spinner_item, dropdownlist2)

        //creating a variable name b1 for button

        val b1= findViewById<Button>(R.id.button)


        //setting the adapters for the view purpose
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_item)


//setting the 1st spinner
        elements1.adapter=adapter
        elements1.onItemSelectedListener=object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
            @SuppressLint("SetTextI18n")
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long){}
        }

        //setting the 2nd spinner
        elements2.adapter=adapter2
        elements2.onItemSelectedListener=object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
            @SuppressLint("SetTextI18n")
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long){}
        }

        //Once the user clicks the button, following text should be displayed based on the selected //items position in relevant array
        b1.setOnClickListener{
            if(elements1.selectedItemPosition==0 && elements2.selectedItemPosition==0)
            {
                textView3.text = "Beef Wellington"
                imageView2.setImageDrawable(resources.getDrawable(R.drawable.meatdry))
            }
            if(elements1.selectedItemPosition==0 && elements2.selectedItemPosition==1)
            {
                textView3.text = "Beef Stew"
                imageView2.setImageDrawable(resources.getDrawable(R.drawable.meatmoist))
            }

            if(elements1.selectedItemPosition==1 && elements2.selectedItemPosition==0)
            {
                textView3.text = "Fried Tempura"
                imageView2.setImageDrawable(resources.getDrawable(R.drawable.seadry))
            }

            if(elements1.selectedItemPosition==1 && elements2.selectedItemPosition==1)
            {
                textView3.text = "Steamed Fish"
                imageView2.setImageDrawable(resources.getDrawable(R.drawable.seamoist))
            }

            if(elements1.selectedItemPosition==2 && elements2.selectedItemPosition==0)
            {
                textView3.text = "Pan-seared Tofu"
                imageView2.setImageDrawable(resources.getDrawable(R.drawable.vegdry))
            }

            if(elements1.selectedItemPosition==2 && elements2.selectedItemPosition==1)
            {
                textView3.text = "Steamed Broccoli"
                imageView2.setImageDrawable(resources.getDrawable(R.drawable.vegmoist))
            }

        }
    }
}