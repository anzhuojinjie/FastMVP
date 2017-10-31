package com.joey.fastmvp.ui.main.activity;

import com.joey.fastmvp.R;
import com.joey.fastmvp.base.BaseActivity;

public class SplashActivity extends BaseActivity {
    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void loadData() {
        startActivity(GuideActivity.class);
        finish();
    }
}
