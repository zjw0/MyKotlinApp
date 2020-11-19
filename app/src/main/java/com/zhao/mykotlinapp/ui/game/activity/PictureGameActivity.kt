package com.zhao.mykotlinapp.ui.game.activity

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.zhao.mykotlinapp.R
import com.zhao.mykotlinapp.base.model.MainViewModel
import com.zhao.mykotlinapp.ui.bean.LoadState
import kotlinx.android.synthetic.main.activity_picture_game.*
import java.util.*

class PictureGameActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picture_game)

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
            val num1 = Random().nextInt(2)
            Glide.with(this)
                .load(it[0])
                .into(if(num1==1){imageViewLeft1}else{imageViewRight1})
            val num2 = Random().nextInt(2)
            Glide.with(this)
                .load(it[1])
                .into(if(num2==1){imageViewLeft2}else{imageViewRight2})
            val num3 = Random().nextInt(2)
            Glide.with(this)
                .load(it[2])
                .into(if(num3==1){imageViewLeft3}else{imageViewRight3})
        })

        //点击刷新按钮来网络加载
        button.setOnClickListener {
            viewModel.getData()
        }
    }
}
