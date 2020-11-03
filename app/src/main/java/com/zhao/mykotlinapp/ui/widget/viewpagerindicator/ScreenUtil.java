package com.zhao.mykotlinapp.ui.widget.viewpagerindicator;

import android.content.Context;

/**
 * Author by Jack_Zhao, Date on 2020/11/2.
 * PS: Not easy to write code, please indicate.
 */
public class ScreenUtil {

    public ScreenUtil() {
    }

    public static int dip2px(Context context, float dpValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int)(dpValue * scale + 0.5F);
    }
}
