package com.asadbek.spinner

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.asadbek.spinner.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var myAdapter: MyAdapter
    lateinit var list: ArrayList<String>
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        list = ArrayList()
        list.add("white")
        list.add("red")
        list.add("black")
        list.add("green")
        list.add("blue")

        binding.spinner.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
               when(position){
                   0 -> binding.main.setBackgroundColor(ContextCompat.getColor(this@MainActivity,R.color.white))
                   1 -> binding.main.setBackgroundColor(ContextCompat.getColor(this@MainActivity,R.color.red))
                   2 -> binding.main.setBackgroundColor(ContextCompat.getColor(this@MainActivity,R.color.black))
                   3 -> binding.main.setBackgroundColor(ContextCompat.getColor(this@MainActivity,R.color.green))
                   4 -> binding.main.setBackgroundColor(ContextCompat.getColor(this@MainActivity,R.color.blue))
               }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }
        myAdapter = MyAdapter(this,list)
        binding.spinner.adapter = myAdapter


    }
}