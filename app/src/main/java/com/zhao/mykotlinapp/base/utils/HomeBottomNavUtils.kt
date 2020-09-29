package com.zhao.mykotlinapp.base.utils

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.zhao.mykotlinapp.R
import java.lang.Exception

/**
 * Describe ：主界面bottom菜单-带红点提示
 */
class HomeBottomNavUtils(private val context: Context, var view: LinearLayout) {

    lateinit var tv_tab1: TextView
    lateinit var tv_tab2: TextView
    lateinit var tv_tab3: TextView
    lateinit var tv_tab4: TextView

    lateinit var iv_tab1: ImageView
    lateinit var iv_tab2: ImageView
    lateinit var iv_tab3: ImageView
    lateinit var iv_tab4: ImageView

    lateinit var rel_tab1: RelativeLayout
    lateinit var rel_tab2: RelativeLayout
    lateinit var rel_tab3: RelativeLayout
    lateinit var rel_tab4: RelativeLayout

    lateinit var listener: onNavBottomListener

    fun initOnclick(listener: onNavBottomListener) {
        this.listener = listener
        tv_tab1 = view.findViewById(R.id.tv_tab1)
        tv_tab2 = view.findViewById(R.id.tv_tab2)
        tv_tab3 = view.findViewById(R.id.tv_tab3)
        tv_tab4 = view.findViewById(R.id.tv_tab4)

        iv_tab1 = view.findViewById(R.id.iv_tab1)
        iv_tab2 = view.findViewById(R.id.iv_tab2)
        iv_tab3 = view.findViewById(R.id.iv_tab3)
        iv_tab4 = view.findViewById(R.id.iv_tab4)

        rel_tab1 = view.findViewById(R.id.rel_tab1)
        rel_tab2 = view.findViewById(R.id.rel_tab2)
        rel_tab3 = view.findViewById(R.id.rel_tab3)
        rel_tab4 = view.findViewById(R.id.rel_tab4)

        rel_tab1.setOnClickListener {
            listener.onItemSelected(0)
        }
        rel_tab2.setOnClickListener {
            listener.onItemSelected(1)
        }
        rel_tab3.setOnClickListener {
            listener.onItemSelected(2)
        }
        rel_tab4.setOnClickListener {
            listener.onItemSelected(3)
        }
    }

    fun showStateColor(pos: Int) {
        when (pos) {
            0 -> {
                tv_tab1.setTextColor(ContextCompat.getColor(context, R.color.text_selected_color))
                iv_tab1.setBackgroundResource(R.mipmap.tab1_selected)
                tv_tab2.setTextColor(ContextCompat.getColor(context, R.color.text_normal_color))
                iv_tab2.setBackgroundResource(R.mipmap.tab2_normal)
                tv_tab3.setTextColor(ContextCompat.getColor(context, R.color.text_normal_color))
                iv_tab3.setBackgroundResource(R.mipmap.tab3_normal)
                tv_tab4.setTextColor(ContextCompat.getColor(context, R.color.text_normal_color))
                iv_tab4.setBackgroundResource(R.mipmap.tab4_normal)
            }
            1 -> {
                tv_tab1.setTextColor(ContextCompat.getColor(context, R.color.text_normal_color))
                iv_tab1.setBackgroundResource(R.mipmap.tab1_normal)
                tv_tab2.setTextColor(ContextCompat.getColor(context, R.color.text_selected_color))
                iv_tab2.setBackgroundResource(R.mipmap.tab2_selected)
                tv_tab3.setTextColor(ContextCompat.getColor(context, R.color.text_normal_color))
                iv_tab3.setBackgroundResource(R.mipmap.tab3_normal)
                tv_tab4.setTextColor(ContextCompat.getColor(context, R.color.text_normal_color))
                iv_tab4.setBackgroundResource(R.mipmap.tab4_normal)
            }
            2 -> {
                tv_tab1.setTextColor(ContextCompat.getColor(context, R.color.text_normal_color))
                iv_tab1.setBackgroundResource(R.mipmap.tab1_normal)
                tv_tab2.setTextColor(ContextCompat.getColor(context, R.color.text_normal_color))
                iv_tab2.setBackgroundResource(R.mipmap.tab2_normal)
                tv_tab3.setTextColor(ContextCompat.getColor(context, R.color.text_selected_color))
                iv_tab3.setBackgroundResource(R.mipmap.tab3_selected)
                tv_tab4.setTextColor(ContextCompat.getColor(context, R.color.text_normal_color))
                iv_tab4.setBackgroundResource(R.mipmap.tab4_normal)
            }
            3 -> {
                tv_tab1.setTextColor(ContextCompat.getColor(context, R.color.text_normal_color))
                iv_tab1.setBackgroundResource(R.mipmap.tab1_normal)
                tv_tab2.setTextColor(ContextCompat.getColor(context, R.color.text_normal_color))
                iv_tab2.setBackgroundResource(R.mipmap.tab2_normal)
                tv_tab3.setTextColor(ContextCompat.getColor(context, R.color.text_normal_color))
                iv_tab3.setBackgroundResource(R.mipmap.tab3_normal)
                tv_tab4.setTextColor(ContextCompat.getColor(context, R.color.text_selected_color))
                iv_tab4.setBackgroundResource(R.mipmap.tab4_selected)
            }
        }
    }

    interface onNavBottomListener {

        fun onItemSelected(pos: Int)
    }

}