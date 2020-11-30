package com.zhao.mykotlinapp.ui.adapter

import android.os.Build
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.zhao.mykotlinapp.R
import com.zhao.mykotlinapp.ui.bean.HomeTypeBean

/**
 * Description:分类-列表纵向滑动分类
 */
class TypeSecondAdapter(layoutRes: Int) :
    BaseQuickAdapter<HomeTypeBean.RSPDATA.LIST, BaseViewHolder>(layoutRes) {

    override fun convert(helper: BaseViewHolder, item: HomeTypeBean.RSPDATA.LIST) {
        try {
            val textView = helper.getView<TextView>(R.id.tv_type)
            textView.text = item.nAME
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}