package com.zhao.mykotlinapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zhao.mykotlinapp.R
import com.zhao.mykotlinapp.base.BaseFragment
import kotlinx.android.synthetic.main.toast_text.*

/**
 * Describe ：购物
 */
class ThirdFragment : BaseFragment() {

    var layoutView: View? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        layoutView = inflater.inflate(R.layout.fragment_fourth, container, false)

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
        tv_text.text = "购物"
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