package com.zhao.mykotlinapp.base.network

/**
 * Author by Jack_Zhao, Date on 2020/10/30.
 * PS: Not easy to write code, please indicate.
 */
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit

//网络层访问统一入口
object NetworkService {

    //retorfit实例，在这里做一些统一网络配置，如添加转换器、设置超时时间等
    private val retrofit = Retrofit.Builder()
        .client(OkHttpClient.Builder().callTimeout(5, TimeUnit.SECONDS).build())
//        .baseUrl("https://api.ooopn.com/")
        .baseUrl("https://api.ixiaowai.cn/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    //网络层访问服务
    val apiService = retrofit.create<ApiService>()

}