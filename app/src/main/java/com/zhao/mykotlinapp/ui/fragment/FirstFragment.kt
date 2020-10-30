package com.zhao.mykotlinapp.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zhao.mykotlinapp.R
import com.zhao.mykotlinapp.base.BaseFragment
import com.zhao.mykotlinapp.ui.activity.ListActivity
import com.zhao.mykotlinapp.base.model.NetPicActivity
import kotlinx.android.synthetic.main.fragment_first.*
import kotlinx.android.synthetic.main.toast_text.tv_text

/**
 * Describe ：首页
 */
class FirstFragment : BaseFragment() {

    var layoutView: View? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        layoutView = inflater.inflate(R.layout.fragment_first, container, false)

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
        tv_text.setOnClickListener {
            startActivity(Intent(activity, ListActivity::class.java))
        }
        tv_text1.setOnClickListener {
            startActivity(Intent(activity, NetPicActivity::class.java))
        }
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