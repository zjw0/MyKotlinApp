package com.zhao.mykotlinapp

import android.app.Application


/**
 * 全局应用配置
 */
class MyApplication : Application() {


    object App {
        var application = MyApplication()
    }

    var isDebug = true

    override fun onCreate() {
        super.onCreate()
        initSetting()
        initBugly()
        initNet()
    }

    fun initSetting() {
        App.application = this

    }


    fun initBugly() {
        try {
            val context = applicationContext
            // 获取当前包名
            val packageName = context.packageName
//            // 获取当前进程名
//            val processName = AppUtils.getProcessName(android.os.Process.myPid())
//            // 设置是否为上报进程
//            val strategy = CrashReport.UserStrategy(context)
//            strategy.isUploadProcess = processName == null || processName == packageName
//            strategy.setAppChannel(BuildConfig.FLAVOR)
//            // 初始化Bugly
//            CrashReport.initCrashReport(context, "840e1e363e", isDebug, strategy)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    /**
     * Okhttp3网络配置
     */
    internal fun initNet() {
//        NetUtilsLib().initNet()
    }

}