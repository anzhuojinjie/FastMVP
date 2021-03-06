package com.joey.loanmarket.base;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;


import com.gyf.barlibrary.ImmersionBar;
import com.joey.loanmarket.R;
import com.joey.loanmarket.app.AppManager;
import com.joey.loanmarket.util.TUtil;

import butterknife.ButterKnife;

/**
 * 创建时间： 2017/10/25.
 * 创 建 人：   joey.
 * 功能描述：
 */
public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity {
    public final static String TAG = "123456";
    public T mPresenter;
    public Context mContext;
    public BaseActivity mActivity;
    public ImmersionBar mImmersionBar;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        mImmersionBar = ImmersionBar.with(this);
        mImmersionBar.fitsSystemWindows(true)  //使用该属性,必须指定状态栏颜色
                .statusBarColor(R.color.colorPrimaryDark)
                .init();
        ButterKnife.bind(this);
        AppManager.getInstance().addActivity(this);
        mContext = this;
        mActivity = this;
        mPresenter = TUtil.getT(this, 0);
        initStatusBar();
        initPresenter();
        loadData();
    }

    private void initStatusBar() {
        //TODO 设置状态栏

    }


    /*********************
     * 子类实现
     *****************************/
    //获取布局文件
    public abstract int getLayoutId();

    //简单页面无需mvp就不用管此方法即可,完美兼容各种实际场景的变通
    public abstract void initPresenter();

    //加载、设置数据
    public abstract void loadData();




    /**
     * 通过Class跳转界面
     **/
    public void startActivity(Class<?> cls) {
        startActivity(cls, null);
    }

    /**
     * 通过Class跳转界面
     **/
    public void startActivityForResult(Class<?> cls, int requestCode) {
        startActivityForResult(cls, null, requestCode);
    }

    /**
     * 含有Bundle通过Class跳转界面
     **/
    public void startActivityForResult(Class<?> cls, Bundle bundle,
                                       int requestCode) {
        Intent intent = new Intent();
        intent.setClass(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }

    /**
     * 含有Bundle通过Class跳转界面
     **/
    public void startActivity(Class<?> cls, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }





    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mImmersionBar != null)
            mImmersionBar.destroy();
        if (mPresenter != null)

            mPresenter.onDestroy();
        AppManager.getInstance().finishActivity(this);
    }
}
