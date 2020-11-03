package com.zhao.mykotlinapp.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.viewpager.widget.ViewPager
import com.youth.banner.BannerConfig
import com.youth.banner.listener.OnBannerListener
import com.zhao.mykotlinapp.R
import com.zhao.mykotlinapp.base.BaseFragment
import com.zhao.mykotlinapp.base.model.NetPicActivity
import com.zhao.mykotlinapp.base.show.T
import com.zhao.mykotlinapp.ui.activity.ListActivity
import com.zhao.mykotlinapp.ui.adapter.HomeTypeAdapter
import com.zhao.mykotlinapp.ui.bean.HomeTypeBean
import com.zhao.mykotlinapp.ui.widget.RoundGlideImageLoader
import kotlinx.android.synthetic.main.fragment_first.*
import kotlinx.android.synthetic.main.toast_text.tv_text

/**
 * Describe ：首页
 */
class FirstFragment : BaseFragment(), OnBannerListener {

    private var layoutView: View? = null
    private lateinit var typeAdapter: HomeTypeAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        layoutView = inflater.inflate(R.layout.fragment_first, container, false)

        return layoutView
    }

    override fun onBackPressed(): Boolean {
        return true
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        tv_text.setOnClickListener {
            startActivity(Intent(activity, ListActivity::class.java))
        }
        tv_text1.setOnClickListener {
            startActivity(Intent(activity, NetPicActivity::class.java))
        }
        //初始化轮播图
        initGallery()
        rv_type.layoutManager = GridLayoutManager(activity, 5)
        typeAdapter = HomeTypeAdapter((R.layout.item_home_type))
        rv_type.adapter = typeAdapter
        typeAdapter.setOnItemClickListener { adapter, view, position ->
            T.showShort(activity,"刷新")
        }
        //模拟数据
        var mList = mutableListOf<HomeTypeBean.RSPDATA.LIST>()
        for (i in 0..4) {
            mList.add(i, HomeTypeBean.RSPDATA.LIST(""+ (i+1), "全部",""))
        }
        var mRSPDATA = HomeTypeBean.RSPDATA(mList)
        var mHomeTypeBean = HomeTypeBean("", mRSPDATA, "")
        typeAdapter.setNewData(mHomeTypeBean.rSPDATA.lIST)
    }

    //轮播图列表
    var urlList = ArrayList<String>()
    var img1 = "https://tva1.sinaimg.cn/large/0072Vf1pgy1foxkezeq4jj31hc0u0qiy.jpg"
    var img2 = "https://tva2.sinaimg.cn/large/0072Vf1pgy1fodqnyvneij31hc0u01kx.jpg"
    var img3 = "https://tva2.sinaimg.cn/large/0072Vf1pgy1foxkczbww6j31hc0u0tod.jpg"
    // 轮播图
    private fun initGallery() {
        urlList.add(img1)
        urlList.add(img2)
        urlList.add(img3)
        //取消指示器
        banner.setBannerStyle(BannerConfig.NOT_INDICATOR)
        //设置图片加载器，图片加载器在下方
        banner.setImageLoader(RoundGlideImageLoader())
        //设置图片网址或地址的集合
        banner.setImages(urlList)
        banner.setBackgroundResource(R.color.transparent)
        banner.setDelayTime(4000)
        banner.setOnBannerListener(this).start()
        indicator_line.setViewPager(banner.viewPager, true)
        banner.setOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                try {
//                    initFlagBg(position)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        })
//        initFlagBg(0)
    }

    override fun onResume() {
        super.onResume()
        try {

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onDestroy() {
        super.onDestroy()

    }

    override fun OnBannerClick(position: Int) {
    }


}