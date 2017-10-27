package com.joey.fastmvp.ui.splash.activity;


import android.os.Build;
import android.view.Window;
import android.view.WindowManager;

import com.joey.fastmvp.R;
import com.joey.fastmvp.base.BaseActivity;
import com.joey.fastmvp.widget.BannerImageLoader;
import com.joey.fastmvp.widget.banner.Banner;
import com.joey.fastmvp.widget.banner.BannerConfig;
import com.joey.fastmvp.widget.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class GuideActivity extends BaseActivity {
    @BindView(R.id.guide_banner)
    Banner mBanner;
    List<Integer> images;
    @Override
    public int getLayoutId() {
        return R.layout.activity_guide;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void loadData() {
        images = new ArrayList<>();
        images.add(R.mipmap.icon_guide1);
        images.add(R.mipmap.icon_guide2);
        images.add(R.mipmap.icon_guide3);
        //设置banner样式
        mBanner.setBannerStyle(BannerConfig.NOT_INDICATOR);
        //设置图片加载器
        mBanner.setImageLoader(new BannerImageLoader());
        //设置图片集合
        mBanner.setImages(images);
        //设置banner动画效果
        mBanner.setBannerAnimation(Transformer.DepthPage);
        //设置自动轮播，默认为true
        mBanner.isAutoPlay(false);
        mBanner.isLoopPlay(false);
        //banner设置方法全部调用完毕时最后调用
        mBanner.start();
    }
}
