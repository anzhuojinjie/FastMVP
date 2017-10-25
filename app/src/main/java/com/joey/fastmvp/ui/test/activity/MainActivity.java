package com.joey.fastmvp.ui.test.activity;

import android.widget.TextView;

import com.joey.fastmvp.R;
import com.joey.fastmvp.base.BaseActivity;
import com.joey.fastmvp.ui.test.bean.HomeIndexResponseBean;
import com.joey.fastmvp.ui.test.contract.MainContract;
import com.joey.fastmvp.ui.test.presenter.MainPresenter;

import butterknife.BindView;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View{
    @BindView(R.id.tv)
    TextView tvResult;
    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }
    @Override
    public void initPresenter() {
        mPresenter.init(this);
    }
    @Override
    public void loadData() {
        mPresenter.loadIndex();
    }
    @Override
    public void showLoading(String content) {
    }
    @Override
    public void stopLoading() {
    }
    @Override
    public void showErrorMsg(String msg, String type) {
    }
    @Override
    public void indexSuccess(HomeIndexResponseBean result) {
        tvResult.setText(result.toString());
    }
}
