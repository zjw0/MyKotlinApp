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
 * Description:首页-列表横向滑动分类
 */
class HomeTypeAdapter(layoutRes: Int) :
    BaseQuickAdapter<HomeTypeBean.RSPDATA.LIST, BaseViewHolder>(layoutRes) {

    override fun convert(helper: BaseViewHolder, item: HomeTypeBean.RSPDATA.LIST) {
        try {
            /**
             * 图片
             */
            val imageView = helper.getView<ImageView>(R.id.iv_type)
            val textView = helper.getView<TextView>(R.id.tv_type)
            Glide.with(mContext).asBitmap().load(item.iMAGE)
                .apply(
                    RequestOptions()
                        .error(R.mipmap.ic_launcher)
                ).into(imageView)
            textView.setText(item.nAME)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}