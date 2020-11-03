package com.zhao.mykotlinapp.ui.widget

import android.content.Context
import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.transition.Transition


/**
 * Describe ：banner-Gilde加载图片
 */
class RoundGlideImageLoader : com.youth.banner.loader.ImageLoader() {

    override fun displayImage(context: Context, path: Any, imageView: ImageView) {
        try {
//            val transform = CornerTransform(context, 12f)
//            val roundedCorners = RoundedCorners(12)
//            var option = RequestOptions().transform(roundedCorners)
//            option.transform(roundedCorners)
//            Glide.with(context).load(path as String).transform(roundedCorners).into(imageView)
            Glide.with(context).load(path as String)
                .into(object : SimpleTarget<Drawable>() {
                    override fun onResourceReady(
                        resource: Drawable,
                        transition: Transition<in Drawable>?
                    ) {
                        imageView.background = resource
                    }
                })
//            Glide.with(context).load(path).into(imageView);
        } catch (e: Exception) {
        }

    }
}