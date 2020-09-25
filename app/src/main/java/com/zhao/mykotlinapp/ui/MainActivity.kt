package com.zhao.mykotlinapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.zhao.mykotlinapp.R
import com.zhao.mykotlinapp.ui.adapter.ListAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: ListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        adapter = ListAdapter(R.layout.item_list)
        rec_view.layoutManager = LinearLayoutManager(this)
        rec_view.adapter = adapter
//        var list = mutableListOf<String>()
        var list = mutableListOf("1","2","3")
        adapter.setNewData(list)
//        list.add("1")
    }
}
