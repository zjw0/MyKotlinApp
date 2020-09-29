package com.zhao.mykotlinapp.base

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.fragment.app.Fragment

import com.tb.m29.base.dialog.WarningTimeDialog
import com.zhao.mykotlinapp.base.BackHandleInterface
import com.zhao.mykotlinapp.base.dialog.LoadingDialog


/**
 * Describe ：
 */
abstract class BaseFragment : Fragment() {

    private var backHandleInterface: BackHandleInterface? = null
    /**
     * 所有继承BackHandledFragment的子类都将在这个方法中实现物理Back键按下后的逻辑
     * FragmentActivity捕捉到物理返回键点击事件后会首先询问Fragment是否消费该事件
     * 如果没有Fragment消息时FragmentActivity自己才会消费该事件
     */
    abstract fun onBackPressed(): Boolean

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (activity is BackHandleInterface) {
            this.backHandleInterface = activity as BackHandleInterface?
        } else {
            throw ClassCastException("Hosting Activity must implement BackHandledInterface")
        }
        initLoading()
    }

    override fun onStart() {
        super.onStart()
        backHandleInterface!!.onSelectedFragment(this)
    }

    /**
     * 加载框
     */
    protected var lld: LoadingDialog? = null


    lateinit var dialog: WarningTimeDialog
    /**
     * @author : luch
     * @params :
     * @return :
     * @remark : 初始化加载框
     */
    private fun initLoading() {
        lld = LoadingDialog(activity)
    }

    /**
     * 自定义消息显示加载
     *
     * @param msg 消息
     */
    fun showLoading(msg: String) {
        try {
            if (lld != null) {
                lld!!.setLoadMsg(msg)
                lld!!.show()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    /**
     * 显示加载
     */
    fun showLoading() {
        try {
            if (lld != null) {
                lld!!.setLoadMsg("")
                lld!!.show()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    /**
     * 检测网络是否可用
     */
    fun isNetworkConnected(): Boolean {
        val cm = activity!!.getSystemService(
            Context.CONNECTIVITY_SERVICE
        ) as ConnectivityManager
        val ni = cm.activeNetworkInfo
        return ni != null && ni.isConnectedOrConnecting
    }

    /**
     * 隐藏加载框
     */
    fun hideLoading() {
        try {
            if (lld != null) {
                lld!!.dismiss()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    /**
     * 超时提醒，重新登录
     *
     * @param msg 提示消息
     */
    fun checkLogin(msg: String) {
        dialog = WarningTimeDialog(activity, msg)
        if (!dialog.isShowing) {
            dialog.show()
        }
    }


    override fun onDestroy() {
        try {
            if (lld != null) {
                lld!!.dismiss()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        super.onDestroy()
    }
}