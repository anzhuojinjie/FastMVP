package com.joey.fastmvp.ui.splash.activity;

import android.os.Build;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import com.joey.fastmvp.R;
import com.joey.fastmvp.base.BaseActivity;
import com.joey.fastmvp.ui.test.activity.MainActivity;
import com.joey.fastmvp.util.Tool;
import com.joey.fastmvp.widget.BannerImageLoader;
import com.joey.fastmvp.widget.banner.Banner;
import com.joey.fastmvp.widget.banner.BannerConfig;
import com.joey.fastmvp.widget.banner.Transformer;

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
        mImmersionBar.reset().init();//取消沉浸式，设置全屏
        if (Build.VERSION.SDK_INT >Build.VERSION_CODES.KITKAT){
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
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
        mBanner.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Log.i("123456", "position-->> "+position+",size-->>"+images.size());
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
