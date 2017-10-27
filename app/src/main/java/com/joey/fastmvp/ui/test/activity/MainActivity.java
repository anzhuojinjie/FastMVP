package com.joey.fastmvp.ui.test.activity;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.joey.fastmvp.R;
import com.joey.fastmvp.base.BaseActivity;
import com.joey.fastmvp.ui.test.bean.HomeIndexResponseBean;
import com.joey.fastmvp.ui.test.contract.MainContract;
import com.joey.fastmvp.ui.test.presenter.MainPresenter;
import com.joey.fastmvp.util.Tool;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {
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

    @OnClick({R.id.toolbar_left_btn})
    public void onClick(View view) {
        if (Tool.isFastDoubleClick()) return;
        switch (view.getId()) {
            case R.id.toolbar_left_btn:
                Toast.makeText(mContext, "点击了返回", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
