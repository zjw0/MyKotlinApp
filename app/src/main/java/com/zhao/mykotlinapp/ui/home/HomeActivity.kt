package com.zhao.mykotlinapp.ui.home


import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Build
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.zhao.mykotlinapp.R
import com.zhao.mykotlinapp.base.BackHandleInterface
import com.zhao.mykotlinapp.base.BaseFragment
import com.zhao.mykotlinapp.base.show.T
import com.zhao.mykotlinapp.base.utils.*
import com.zhao.mykotlinapp.ui.fragment.FirstFragment
import com.zhao.mykotlinapp.ui.fragment.FourthFragment
import com.zhao.mykotlinapp.ui.fragment.SecondFragment
import com.zhao.mykotlinapp.ui.fragment.ThirdFragment
import kotlinx.android.synthetic.main.layout_home_bottom.*


/**
 * Describe ：主界面容器
 */
class HomeActivity : FragmentActivity(), BackHandleInterface {

    private val manager: FragmentManager = supportFragmentManager
    lateinit var transaction: FragmentTransaction
    var mFirstFragment: FirstFragment? = null
    var mSecondFragment: SecondFragment? = null
    var mThirdFragment: ThirdFragment? = null
    var mFourthFragment: FourthFragment? = null


    //fragment tag参数标识
    var tab1 = "tag1"
    var tab2 = "tag2"
    var tab3 = "tag3"
    var tab4 = "tag4"

    lateinit var navUtils: HomeBottomNavUtils

    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        //8.0透明主题与竖屏崩溃问题
        if (android.os.Build.VERSION.SDK_INT != Build.VERSION_CODES.O) {
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        }
        super.onCreate(savedInstanceState)
        AppManager.getAppManager().addActivity(this)
        setContentView(attachLayoutRes())
        initViews()
        initData()
    }

    fun attachLayoutRes(): Int {
        return R.layout.activity_home
    }

    fun initViews() {
        navUtils = HomeBottomNavUtils(this, lin_bottom)
        navUtils.initOnclick(object : HomeBottomNavUtils.onNavBottomListener {
            override fun onItemSelected(pos: Int) {
                when (pos) {
                    0 -> {
                        showFragment(tab1)
                    }
                    1 -> {
                        showFragment(tab2)
                    }
                    2 -> {
                        showFragment(tab3)
                    }
                    3 -> {
                        showFragment(tab4)
                    }
                }
            }

        })
        navUtils.showStateColor(0)
        transaction = manager.beginTransaction()
        showFragment(tab1)
    }


    /**
     * 设置不跟随系统字体大小 取app内部字体大小
     */
    override fun onConfigurationChanged(newConfig: Configuration) {
        if (newConfig!!.fontScale != 1f) {
            //非默认值
            getResources()
        }
        super.onConfigurationChanged(newConfig)
    }

    override fun getResources(): Resources {
        val res = super.getResources()
        val config = Configuration()
        config.setToDefaults()
        res.updateConfiguration(config, res.displayMetrics)
        return res
    }


    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }


    override fun onDestroy() {
        // 结束Activity&从堆栈中移除
        AppManager.getAppManager().finishActivity(this)
        super.onDestroy()
    }

    fun showFragment(tag: String) {
        var ft = manager.beginTransaction()
        hideFragment(ft, tag)
        when (tag) {
            tab1 -> {
                navUtils.showStateColor(0)
                //状态栏字体变为白色
                StatusBarUtils.setStatusBarDarkTheme(this@HomeActivity, false)
                if (mFirstFragment == null) {
                    mFirstFragment = FirstFragment()
                    mFirstFragment?.let { ft.add(R.id.content, it, tab1) }
                } else {
                    mFirstFragment =
                        supportFragmentManager.findFragmentByTag(tab1) as FirstFragment?
                    mFirstFragment?.let { ft.show(it) }
                }

            }
            tab2 -> {
                navUtils.showStateColor(1)
                //状态栏字体变为白色
                StatusBarUtils.setStatusBarDarkTheme(this@HomeActivity, false)
                if (mSecondFragment == null) {
                    mSecondFragment = SecondFragment()
                    mSecondFragment?.let { ft.add(R.id.content, it, tab2) }
                } else {
                    mSecondFragment =
                        supportFragmentManager.findFragmentByTag(tab2) as SecondFragment?
                    mSecondFragment?.let { ft.show(it) }
                }
            }
            tab3 -> {
                navUtils.showStateColor(2)
                //状态栏字体变为白色
                StatusBarUtils.setStatusBarDarkTheme(this@HomeActivity, false)
                if (mThirdFragment == null) {
                    mThirdFragment = ThirdFragment()
                    mThirdFragment?.let { ft.add(R.id.content, it, tab3) }
                } else {
                    mThirdFragment =
                        supportFragmentManager.findFragmentByTag(tab3) as ThirdFragment?
                    mThirdFragment?.let { ft.show(it) }
                }
            }
            tab4 -> {
                navUtils.showStateColor(3)
                //状态栏字体变为深色
                StatusBarUtils.setStatusBarDarkTheme(this@HomeActivity, true)
                if (mFourthFragment == null) {
                    mFourthFragment = FourthFragment()
                    var bundle = Bundle()
                    mFourthFragment!!.arguments = bundle
                    mFourthFragment?.let { ft.add(R.id.content, it, tab4) }
                } else {
                    mFourthFragment =
                        supportFragmentManager.findFragmentByTag(tab4) as FourthFragment?
                    mFourthFragment?.let { ft.show(it) }
                }

            }
        }
        ft.commit()

    }

    fun hideFragment(ft: FragmentTransaction, tag: String) {
        try {
            //如果不为空，就先隐藏起来
            if (mFirstFragment != null) {
                mFirstFragment = supportFragmentManager.findFragmentByTag(tab1) as FirstFragment?
                ft.hide(mFirstFragment!!)
            }
            if (mSecondFragment != null) {
                mSecondFragment = supportFragmentManager.findFragmentByTag(tab2) as SecondFragment?
                ft.hide(mSecondFragment!!)
            }
            if (mThirdFragment != null) {
                mThirdFragment = supportFragmentManager.findFragmentByTag(tab3) as ThirdFragment?
                ft.hide(mThirdFragment!!)
            }
            if (mFourthFragment != null) {
                mFourthFragment = supportFragmentManager.findFragmentByTag(tab4) as FourthFragment?
                ft.hide(mFourthFragment!!)
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    lateinit var baseFragment: BaseFragment


    override fun onSelectedFragment(backHandleFragment: BaseFragment) {
        this.baseFragment = backHandleFragment
    }


    override fun initData() {

    }

    var exit = ExitTool()

    /**
     * fragment返回键接受
     */
    override fun onBackPressed() {
        pressAgainExit()
        //if判断里面就调用了来自Fragment的onBackPressed()
        //一样！！，如果onBackPressed是返回false，就会进入条件内进行默认的操作
        if (!baseFragment.onBackPressed()) {

        }
    }

    private fun pressAgainExit() {
        if (exit.isExit()) {
            AppManager.getAppManager().finishAllActivity()
            finish()
        } else {
            T.showBottomShort(this, "再按一次退出APP")
            exit.doExitInOneSecond()
        }
    }

}