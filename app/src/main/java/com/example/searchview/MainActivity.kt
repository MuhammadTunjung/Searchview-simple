package com.example.searchview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SearchView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val search = findViewById<SearchView>(R.id.searchView)
        val listView = findViewById<ListView>(R.id.listView)

        val nama = arrayOf("Programming dengan Swift", "Program pencarian", "Bahasa Pem Programan", "Buat Project baru")



        val adapter:ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1, nama
        )

        listView.adapter = adapter

        search.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(string: String?): Boolean {
                search.clearFocus()
                if (nama.contains(string))
                {
                    adapter.filter.filter(string)
                }else{
                    Toast.makeText(applicationContext,"Pencarian Tidak di Temukan", Toast.LENGTH_LONG).show()
                }
                return false
            }

            override fun onQueryTextChange(string: String?): Boolean {
                adapter.filter.filter(string)
                return false
            }

        })
    }
}