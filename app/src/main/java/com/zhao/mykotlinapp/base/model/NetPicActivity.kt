package com.zhao.mykotlinapp.base.model

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.zhao.mykotlinapp.R
import com.zhao.mykotlinapp.ui.bean.LoadState
import kotlinx.android.synthetic.main.activity_net_pic.*
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import com.fanjun.keeplive.KeepLive

class NetPicActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_net_pic)

        //获取ViewModel
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        //对加载状态进行动态观察
        viewModel.loadState.observe(this, Observer {
            when (it) {
                is LoadState.Success -> button.isEnabled = true
                is LoadState.Fail -> {
                    button.isEnabled = true
                    Log.i("请求信息",it.msg)
                    Toast.makeText(this, it.msg, Toast.LENGTH_SHORT).show()
                }
                is LoadState.Loading -> {
                    button.isEnabled = false
                }
            }

        })

        //对图片Url数据进行观察
        viewModel.imageData.observe(this, Observer {
            //用Glide加载三张图片
            Glide.with(this)
                .load(it[0])
                .into(imageView1)
            Glide.with(this)
                .load(it[1])
                .into(imageView2)
            Glide.with(this)
                .load(it[2])
                .into(imageView3)
        })

        //点击刷新按钮来网络加载
        button.setOnClickListener {
            viewModel.getData()
        }
        //点击停止服务
        bt_stop.setOnClickListener {
            //退出APP关掉后台保活服务
            if (KeepLive.keepLiveService != null) {
                KeepLive.keepLiveService.onStop()
            }
                if(Build.VERSION.SDK_INT >= 26) {
                    val notificationManager: NotificationManager =
                        getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
//                    notificationManager.cancel(13691)
                    notificationManager.cancel(this.packageName.toInt())
                    notificationManager.cancelAll()
                }
        }
    }
}
