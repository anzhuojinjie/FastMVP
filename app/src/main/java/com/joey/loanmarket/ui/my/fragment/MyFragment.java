package com.joey.loanmarket.ui.my.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.joey.loanmarket.R;
import com.joey.loanmarket.base.BaseFragment;
import com.joey.loanmarket.glide.GlideCircleTransform;
import com.joey.loanmarket.util.Tool;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * 创建时间： 2017/10/25.
 * 创 建 人：   joey.
 * 功能描述：
 */
public class MyFragment extends BaseFragment {

    @BindView(R.id.my_iv_head)
    ImageView mIvHead;
    @BindView(R.id.mt_tv_login)
    TextView mTvLogin;
    @BindView(R.id.ll_my_logout)
    LinearLayout mLLLogout;
    @BindView(R.id.ll_my_login)
    LinearLayout mLLLogin;



    public MyFragment() {
        // Required empty public constructor
    }
    @Override
    public int getLayoutId() {
        return R.layout.fragment_my;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void loadData() {
        Glide.with(getContext()).load(R.mipmap.my_iv_src_personal)
                // 加载图片
                .error(R.mipmap.my_iv_src_personal)
                // 设置错误图片
                .crossFade()
                // 设置淡入淡出效果，默认300ms，可以传参
                .placeholder(R.mipmap.my_iv_src_personal)
                // 设置占位图
                .transform(new GlideCircleTransform(getContext()))//圆角
                .diskCacheStrategy(DiskCacheStrategy.RESULT)// 缓存修改过的图片
                .into(mIvHead);
    }

    @OnClick({R.id.mt_tv_login})
    public void onClick(View view) {
        if (Tool.isFastDoubleClick()) return;
        switch (view.getId()) {
            case R.id.mt_tv_login:
                mLLLogin.setVisibility(View.VISIBLE);
                mLLLogout.setVisibility(View.GONE);
                break;
            default:
                break;
        }
    }

}
