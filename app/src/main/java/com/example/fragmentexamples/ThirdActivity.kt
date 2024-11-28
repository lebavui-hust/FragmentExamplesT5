package com.example.fragmentexamples

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ThirdActivity : AppCompatActivity(), ItemClickListener {

    val listFragment = ListFragment()
    val detailFragment = DetailFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

//        val fragment1 = BlankFragment.newInstance("RED", "Hello")
//        val fragment2 = BlankFragment.newInstance("GREEN", "World")
//
//        supportFragmentManager.beginTransaction()
//            .add(R.id.container1, fragment1)
//            .add(R.id.container2, fragment2)
//            .commit()

        supportFragmentManager.beginTransaction()
            .add(R.id.container1, listFragment)
            .add(R.id.container2, detailFragment)
            .commit()
    }

    override fun OnItemClicked(item: String) {
        detailFragment.UpdateContent(item)
    }
}