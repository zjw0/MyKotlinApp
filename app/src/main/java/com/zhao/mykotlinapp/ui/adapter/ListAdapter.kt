package com.zhao.mykotlinapp.ui.adapter

import android.widget.EditText
import android.widget.ImageView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.zhao.mykotlinapp.R
import com.zhao.mykotlinapp.ui.bean.DataListBean

/**
 * Describe ：未接单
 */
class ListAdapter(layoutID: Int) :
    BaseQuickAdapter<DataListBean.RSPDATA.LIST, BaseViewHolder>(layoutID) {

    override fun convert(helper: BaseViewHolder, item: DataListBean.RSPDATA.LIST) {
        var index = helper.layoutPosition
        var etName = helper.getView<EditText>(R.id.et_name)
        var ivSelect = helper.getView<ImageView>(R.id.iv_select)
//        helper.setText(R.id.et_name, "请赐予我名字")
//        helper.setText(R.id.iv_pic, "")
        //是否可输入
        etName.isEnabled = item.isLock.equals("00")
        if (item.isLock.equals("00")) {
//            helper.setText(R.id.et_name, "未分拣")
            helper.setImageResource(R.id.iv_select, R.mipmap.home_sel_icon_n)
        } else {
//            helper.setText(R.id.et_name, "已分拣")
            helper.setImageResource(R.id.iv_select, R.mipmap.home_noc_icon_n)
        }
        //是否锁定
        ivSelect.setOnClickListener {
            //00 未分拣 01 已分拣（锁定）
            if (item.isLock.equals("00")) {
                item.isLock = "01"
//                notifyItemChanged(index)
                notifyDataSetChanged()
            } else if(item.isLock.equals("01")){
                item.isLock = "00"
//                notifyItemChanged(index)
                notifyDataSetChanged()
            }

        }

    }

}