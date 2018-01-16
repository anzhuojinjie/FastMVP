package com.joey.loanmarket.ui.main.activity;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import com.joey.loanmarket.R;
import com.joey.loanmarket.base.BaseActivity;
import com.joey.loanmarket.util.Tool;
import com.joey.loanmarket.widget.BannerImageLoader;
import com.joey.loanmarket.widget.banner.Banner;
import com.joey.loanmarket.widget.banner.BannerConfig;
import com.joey.loanmarket.widget.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class GuideActivity extends BaseActivity {
    @BindView(R.id.guide_banner)
    Banner mBanner;
    @BindView(R.id.btn_enter)
    Button btnEnter;
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
        mImmersionBar.reset().init();//取消沉浸式，用过样式设置全屏
        images = new ArrayList<>();
        images.add(R.mipmap.icon_guide1);
        images.add(R.mipmap.icon_guide2);
        images.add(R.mipmap.icon_guide3);
        mBanner.setBannerStyle(BannerConfig.NOT_INDICATOR);
        mBanner.setImageLoader(new BannerImageLoader());
        mBanner.setImages(images);
        mBanner.setBannerAnimation(Transformer.DepthPage);
        mBanner.isAutoPlay(false);
        mBanner.isLoopPlay(false);
        mBanner.start();
        mBanner.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == images.size()-1){
                    btnEnter.setVisibility(View.VISIBLE);
                }else{
                    btnEnter.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    @OnClick({R.id.btn_enter})
    public void onClick(View view) {
        if (Tool.isFastDoubleClick()) return;
        switch (view.getId()) {
            case R.id.btn_enter:
                startActivity(MainActivity.class);
                finish();
                break;
            default:
                break;
        }
    }

}
