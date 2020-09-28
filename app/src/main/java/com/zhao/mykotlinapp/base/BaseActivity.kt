package com.zhao.mykotlinapp.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tb.m29.base.dialog.WarningTimeDialog
import com.zhao.mykotlinapp.base.dialog.LoadingDialog
import com.zhao.mykotlinapp.base.entity.Entity
import com.zhao.mykotlinapp.base.show.T
import com.zhao.mykotlinapp.base.utils.AppManager

/**
 * Author by Jack_Zhao, Date on 2020/9/28.
 * PS: Not easy to write code, please indicate.
 */
abstract class BaseActivity: AppCompatActivity() {

    /**
     * 加载框
     */
    protected var lld: LoadingDialog? = null


    lateinit var dialog: WarningTimeDialog

    /**
     * 绑定布局文件
     *
     * @return 布局文件ID
     */
    protected abstract fun attachLayoutRes(): Int

    /**
     * 初始化视图控件
     */
    protected abstract fun initViews()

    /**
     * 初始化数据
     */
    protected abstract fun initData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            setContentView(attachLayoutRes())
            AppManager.getAppManager().addActivity(this)
            initViews()
            init()
            initData()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


    private fun init() {
        lld = LoadingDialog(this)
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
     * 通用返回错误码判断，其他错误自定义需自己重写
     *
     * @param code 错误码
     * @param msg 提示消息
     */
    fun checkCode(code: String, msg: String) {
        if (code.equals(Entity.STATE_OUT_TIME)) {
            checkLogin(msg)
        } else {
            T.showShort(this, msg)
        }
    }

    /**
     * 通用返回错误码判断，其他错误自定义需自己重写
     *
     * @param code 错误码
     * @param msg 提示消息
     */
    fun checkLongCode(code: String, msg: String) {
        if (code.equals(Entity.STATE_OUT_TIME)) {
            checkLogin(msg)
        } else {
            T.showLong(this, msg)
        }
    }


    override fun onDestroy() {
        try {
            if (lld != null) {
                lld!!.dismiss()
            }
            AppManager.getAppManager().finishActivity(this)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        super.onDestroy()
    }

    /**
     * 超时提醒，重新登录
     *
     * @param msg 提示消息
     */
    fun checkLogin(msg: String) {
        dialog = WarningTimeDialog(this, msg)
        if (!dialog.isShowing) {
            dialog.show()
        }
    }
}