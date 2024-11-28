package com.example.fragmentexamples

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView

class ListFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)

        val items = mutableListOf<String>()
        for (i in 1..50)
            items.add("Item $i")

        val adapter = ArrayAdapter(requireContext(),
            android.R.layout.simple_list_item_1, items)

        val listView = view.findViewById<ListView>(R.id.list_view)
        listView.adapter = adapter

        listView.setOnItemClickListener { parent, view, position, id ->
            val item = items[position]
            if (activity is ItemClickListener)
                (activity as ItemClickListener).OnItemClicked(item)
        }

        return view
    }
}