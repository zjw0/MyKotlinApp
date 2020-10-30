package com.zhao.mykotlinapp.base.network

/**
 * Author by Jack_Zhao, Date on 2020/10/30.
 * PS: Not easy to write code, please indicate.
 */
import com.zhao.mykotlinapp.ui.bean.ImageDataResponseBody
import retrofit2.http.GET
import retrofit2.http.Query

//网络接口
interface ApiService {

    //声明为suspend方法
//    @GET("image/sogou/api.php")
//    suspend fun getImage(@Query("type") type: String = "json"): ImageDataResponseBody

    @GET("api/api.php")
    suspend fun getImage(@Query("return") type: String = "json"): ImageDataResponseBody
}