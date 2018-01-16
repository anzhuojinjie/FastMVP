package com.joey.loanmarket.ui.main.activity;

import com.joey.loanmarket.R;
import com.joey.loanmarket.base.BaseActivity;

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
