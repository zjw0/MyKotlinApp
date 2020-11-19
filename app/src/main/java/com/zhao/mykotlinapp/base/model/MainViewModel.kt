package com.zhao.mykotlinapp.base.model

/**
 * Author by Jack_Zhao, Date on 2020/10/30.
 * PS: Not easy to write code, please indicate.
 */
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zhao.mykotlinapp.ui.bean.LoadState
import com.zhao.mykotlinapp.base.network.NetworkService
import com.zhao.mykotlinapp.ui.bean.ImageDataResponseBody
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.Deferred as Deferred

class MainViewModel : ViewModel() {

    //存放三张图片的url数据
    val imageData = MutableLiveData<List<String>>()
    //存放网路加载状态信息
    val loadState = MutableLiveData<LoadState>()

    //从网络加载数据
    fun getData() {
        viewModelScope.launch(CoroutineExceptionHandler { _, e ->
            //加载失败的状态
            loadState.value = LoadState.Fail(e.message ?: "加载失败")
        }) {
            //更新加载状态
            loadState.value = LoadState.Loading()

            //并发请求三张图片的数据
            val data1 = async { NetworkService.apiService.getImage() }
            val data2 = async { NetworkService.apiService.getImage() }
            val data3 = async { NetworkService.apiService.getImage() }
//            var list = Deferred<ImageDataResponseBody>()
//            for (i in 0..8) list.addAll(async { NetworkService.apiService.getImage() })

            //通过为LiveData设置新的值来触发更新UI
            imageData.value = listOf(data1.await(), data2.await(), data3.await()).map {
                it.imgurl
            }
            //更新加载状态
            loadState.value = LoadState.Success()
        }
    }


}