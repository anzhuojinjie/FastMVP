package com.joey.fastmvp.ui.splash.activity;

import com.joey.fastmvp.R;
import com.joey.fastmvp.base.BaseActivity;
import com.joey.fastmvp.ui.test.activity.MainActivity;

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
        startActivity(MainActivity.class);
        finish();
    }
}
