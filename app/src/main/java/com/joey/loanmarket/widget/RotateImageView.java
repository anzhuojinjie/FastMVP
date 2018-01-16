package com.joey.loanmarket.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

/**
 * Imageview做一个旋转动画
 */

@SuppressLint("AppCompatCustomView")
public class RotateImageView extends ImageView {
    public RotateImageView(Context context) {
        super(context);
    }

    public RotateImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public RotateImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * ImageView做一个围绕中心点旋转的动画
     * @param fromDegrees    起始角度
     * @param toDegrees      结束角度
     * @param durationMillis 动画执行时间
     */
    public void doRotate(float fromDegrees, float toDegrees,long durationMillis){
        Animation rotateAnimation  = new RotateAnimation(fromDegrees, toDegrees, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setDuration(durationMillis);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        startAnimation(rotateAnimation);
    }
}
