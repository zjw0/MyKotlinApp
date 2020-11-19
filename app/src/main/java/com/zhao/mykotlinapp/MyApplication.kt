package com.zhao.mykotlinapp

import android.app.Application
import com.fanjun.keeplive.KeepLive
import com.fanjun.keeplive.config.ForegroundNotification
import com.fanjun.keeplive.config.ForegroundNotificationClickListener
import com.fanjun.keeplive.config.KeepLiveService


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

        //定义前台服务的默认样式。即标题、描述和图标
//        val foregroundNotification =
//            ForegroundNotification("随心", "运行中", R.mipmap.ic_launcher,  //定义前台服务的通知点击事件
//                ForegroundNotificationClickListener { context, intent -> })
//        //启动保活服务
//        KeepLive.startWork(this,
//            KeepLive.RunMode.ENERGY,
//            foregroundNotification,  //你需要保活的服务，如socket连接、定时任务等，建议不用匿名内部类的方式在这里写
//            object : KeepLiveService {
//                /**
//                 * 运行中
//                 * 由于服务可能会多次自动启动，该方法可能重复调用
//                 */
//                override fun onWorking() {}
//
//                /**
//                 * 服务终止
//                 * 由于服务可能会被多次终止，该方法可能重复调用，需同onWorking配套使用，如注册和注销broadcast
//                 */
//                override fun onStop() {
//
//                }
//            }
//        )

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