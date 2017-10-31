package com.joey.fastmvp.ui.test.activity;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.joey.fastmvp.R;
import com.joey.fastmvp.base.BaseActivity;
import com.joey.fastmvp.ui.test.bean.HomeIndexResponseBean;
import com.joey.fastmvp.ui.test.contract.MainContract;
import com.joey.fastmvp.ui.test.presenter.MainPresenter;
import com.joey.fastmvp.util.ToastUtil;
import com.joey.fastmvp.util.Tool;

import butterknife.BindView;
import butterknife.OnClick;
/**
 * 创建时间： 2017/10/25.
 * 创 建 人：   joey.
 * 功能描述： 一个网络请求的demo
 */
public class TestActivity extends BaseActivity<MainPresenter> implements MainContract.View {
    @BindView(R.id.tv)
    TextView tvResult;


    @Override
    public int getLayoutId() {
        return R.layout.activity_test;
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
        ToastUtil.getInstance().showToast(msg);
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
