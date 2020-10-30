package com.zhao.mykotlinapp.ui.bean

/**
 * Author by Jack_Zhao, Date on 2020/10/30.
 * PS: Not easy to write code, please indicate.
 */
sealed class LoadState(val msg: String) {
    class Loading(msg: String = "") : LoadState(msg)
    class Success(msg: String = "") : LoadState(msg)
    class Fail(msg: String) : LoadState(msg)
}