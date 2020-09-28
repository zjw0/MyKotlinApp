package com.zhao.mykotlinapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.zhao.mykotlinapp.R
import com.zhao.mykotlinapp.ui.adapter.ListAdapter
import com.zhao.mykotlinapp.ui.bean.DataListBean
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: ListAdapter
    private lateinit var mDataListBean: DataListBean

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        adapter = ListAdapter(R.layout.item_list)
        rec_view.layoutManager = LinearLayoutManager(this)
        rec_view.adapter = adapter
        //模拟数据
//        var list = mutableListOf("1","2","3")
//        adapter.setNewData(list)
        //模拟数据
        var mList = mutableListOf<DataListBean.RSPDATA.LIST>()
        var list = DataListBean.RSPDATA.LIST("", "00")
        for (i in 0..3) {
            mList.add(i, list)
        }
        var mRSPDATA = DataListBean.RSPDATA(mList)
        mDataListBean = DataListBean("", mRSPDATA, "")
        adapter.setNewData(mDataListBean.rSPDATA.lIST)
    }
}
