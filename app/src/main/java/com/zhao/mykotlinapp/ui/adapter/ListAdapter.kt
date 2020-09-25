package com.zhao.mykotlinapp.ui.adapter

import android.text.TextUtils
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder

/**
 * Describe ：未接单
 */
class ListAdapter(layoutID: Int) :
    BaseQuickAdapter<String, BaseViewHolder>(layoutID) {

    override fun convert(helper: BaseViewHolder, item: String) {
//        try {
//
//            helper.setText(R.id.tv_order_id, item.oRDERID)
//            helper.setText(R.id.tv_time, DateUtil.longDateparsedMin(item.sHOWSDELIVERYTIME))
//            helper.setText(
//                R.id.tv_adress,
//                AddressTool().formatAddress(item.oRDERRECEADDS, item.rECEADDS)
//            )
//
//            if (!TextUtils.isEmpty(item.oRDERDESC)) {
//                helper.setGone(R.id.rl_remark, true)
//                helper.setText(R.id.tv_remark, "备注: " + item.oRDERDESC)
//            } else {
//                helper.setGone(R.id.rl_remark, false)
//            }
//            helper.addOnClickListener(R.id.tv_jdfj)
//        } catch (e: Exception) {
//            e.printStackTrace()
//        }

    }

}