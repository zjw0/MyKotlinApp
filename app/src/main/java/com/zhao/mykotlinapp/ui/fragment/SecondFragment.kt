package com.zhao.mykotlinapp.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.zhao.mykotlinapp.R
import com.zhao.mykotlinapp.base.BaseFragment
import com.zhao.mykotlinapp.base.show.T
import com.zhao.mykotlinapp.ui.adapter.TypeSecondAdapter
import com.zhao.mykotlinapp.ui.adapter.TypeSecondRightAdapter
import com.zhao.mykotlinapp.ui.bean.HomeTypeBean
import com.zhao.mykotlinapp.ui.game.activity.PictureGameActivity
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.fragment_book_store.*
import kotlinx.android.synthetic.main.toast_text.*

/**
 * Describe ：搜索
 */
class SecondFragment : BaseFragment() {

    private lateinit var typeSecondAdapter: TypeSecondAdapter
    private lateinit var typeSecondRightAdapter: TypeSecondRightAdapter
    var layoutView: View? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        layoutView = inflater.inflate(R.layout.fragment_book_store, container, false)

        return layoutView
    }

    override fun onBackPressed(): Boolean {
        return true
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        srl_book_list.setOnRefreshListener {
            srl_book_list.finishRefresh()
        }
        rv_type_list.layoutManager = LinearLayoutManager(activity)
        typeSecondAdapter = TypeSecondAdapter((R.layout.item_type_second))
        rv_type_list.adapter = typeSecondAdapter
        typeSecondAdapter.setOnItemClickListener { adapter, view, position ->
            T.showShort(activity,"书籍分类")
        }
        //模拟数据
        var mList = mutableListOf<HomeTypeBean.RSPDATA.LIST>()
        for (i in 0..4) {
            mList.add(i, HomeTypeBean.RSPDATA.LIST(""+ (i+1), "书籍分类",""))
        }
        var mRSPDATA = HomeTypeBean.RSPDATA(mList)
        var mHomeTypeBean = HomeTypeBean("", mRSPDATA, "")
        typeSecondAdapter.setNewData(mHomeTypeBean.rSPDATA.lIST)

        //书籍列表
        rv_book_list.layoutManager = LinearLayoutManager(activity)
        typeSecondRightAdapter = TypeSecondRightAdapter((R.layout.item_type_second_right))
        rv_book_list.adapter = typeSecondRightAdapter
        typeSecondRightAdapter.setOnItemClickListener { adapter, view, position ->
            T.showShort(activity,"书籍分类")
        }
        //模拟数据
//        var mList = mutableListOf<HomeTypeBean.RSPDATA.LIST>()
//        for (i in 0..4) {
//            mList.add(i, HomeTypeBean.RSPDATA.LIST(""+ (i+1), "分类",""))
//        }
//        var mRSPDATA = HomeTypeBean.RSPDATA(mList)
//        var mHomeTypeBean = HomeTypeBean("", mRSPDATA, "")
        typeSecondRightAdapter.setNewData(mHomeTypeBean.rSPDATA.lIST)

    }


    override fun onResume() {
        super.onResume()
        try {

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onDestroy() {
        super.onDestroy()

    }


}