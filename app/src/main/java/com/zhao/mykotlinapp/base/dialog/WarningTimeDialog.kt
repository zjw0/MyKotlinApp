package com.tb.m29.base.dialog

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.zhao.mykotlinapp.R
import com.zhao.mykotlinapp.base.utils.AppManager


/**
 * 超时弹出框
 */
class WarningTimeDialog(context: Context?, msg: String) : Dialog(context!!, R.style.MyDialog) {

    lateinit var view: View

    var msg: String = msg

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        view = LayoutInflater.from(context).inflate(R.layout.dialog_warningtime, null);
        val width = (context.resources.displayMetrics.widthPixels * 0.85).toInt()
        this.setContentView(
            view,
            ViewGroup.LayoutParams(width, ViewGroup.LayoutParams.WRAP_CONTENT)
        )
        var icon = findViewById<ImageView>(R.id.icon)
        var txmsg = findViewById<TextView>(R.id.message)
        var title = findViewById<TextView>(R.id.dialogTitle)
        var cencel = findViewById<TextView>(R.id.cencel)
        var confirm = findViewById<TextView>(R.id.confirm)
        txmsg.text = msg
        confirm.setOnClickListener {
            dismiss()
            try {
                //单点登录移除登录状态
//                SharedPreferencesUtil.getInstance().isLogin = false
//                SharedPreferencesUtil.getInstance().remove("userId")
//                SharedPreferencesUtil.getInstance().remove("ROLE_STATE")
//                SharedPreferencesUtil.getInstance().remove("token")
                val manager = AppManager.getAppManager()
                manager.finishAllActivity()
                var intent = context.packageManager.getLaunchIntentForPackage(context.packageName)
                intent!!.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                context.startActivity(intent)
            } catch (e: Exception) {
            }

        }
        setCancelable(false)
    }


}