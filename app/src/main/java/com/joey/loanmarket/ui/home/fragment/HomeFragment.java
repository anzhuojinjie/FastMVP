package com.joey.loanmarket.ui.home.fragment;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.joey.loanmarket.R;
import com.joey.loanmarket.base.BaseFragment;
import com.joey.loanmarket.base.WebActivity;
import com.joey.loanmarket.util.ToastUtil;
import com.joey.loanmarket.util.Tool;
import com.joey.loanmarket.widget.BannerImageLoader;
import com.joey.loanmarket.widget.UPMarqueeView;
import com.joey.loanmarket.widget.banner.Banner;
import com.joey.loanmarket.widget.banner.BannerConfig;
import com.joey.loanmarket.widget.banner.Transformer;
import com.joey.loanmarket.widget.banner.listener.OnBannerListener;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import ezy.ui.layout.LoadingLayout;


/**
 * 创建时间： 2017/10/25.
 * 创 建 人：   joey.
 * 功能描述：
 */
public class HomeFragment extends BaseFragment implements OnBannerListener{

    @BindView(R.id.ll_root)
    SmartRefreshLayout llRoot;
    @BindView(R.id.banner)
    Banner mBanner;
    @BindView(R.id.upview)
    UPMarqueeView marqueeView;
    List<String> data = new ArrayList<>();
    List<View> views = new ArrayList<>();

    List<String> images;
    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void loadData() {
        mLoading = LoadingLayout.wrap(llRoot);
        mLoading.setRetryListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO 点击重试按钮可以再次请求网络，用于数据的展示
            }
        });
        mLoading.showContent();
        llRoot.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refreshlayout.finishRefresh(2000);
            }
        });
        llRoot.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                refreshlayout.finishLoadmore(2000);
            }
        });

        images = new ArrayList<>();
        images.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic1xjab4j30ci08cjrv.jpg");
        images.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic21363tj30ci08ct96.jpg");
        images.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic259ohaj30ci08c74r.jpg");
        images.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic2b16zuj30ci08cwf4.jpg");
        images.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic2e7vsaj30ci08cglz.jpg");
        mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
                .setImageLoader(new BannerImageLoader())
                .setImages(images)
                .setBannerAnimation(Transformer.DepthPage)
                .isAutoPlay(true)
                .setDelayTime(1500)
                .setIndicatorGravity(BannerConfig.RIGHT)
                .setOnBannerListener(this)
                .start();


        initdata();
        initView();

    }

    @OnClick({R.id.toolbar_right_btn})
    public void onClick(View view) {
        if (Tool.isFastDoubleClick()) return;
        switch (view.getId()) {
            case R.id.toolbar_right_btn:
                ToastUtil.getInstance().showToast("消息中心");
                Intent intent = new Intent(getActivity(),WebActivity.class);
                intent.putExtra("title","百度");
                intent.putExtra("url","http://www.baidu.com");
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    @Override
    public void OnBannerClick(int position) {
        ToastUtil.getInstance().showToast("点击了"+position);
    }


    /**
     * 初始化界面程序
     */
    private void initView() {
        setView();
        marqueeView.setViews(views);
        /**
         * 设置item_view的监听
         */
        marqueeView.setOnItemClickListener(new UPMarqueeView.OnItemClickListener() {
            @Override
            public void onItemClick(int position, View view) {
                Toast.makeText(getActivity(), "你点击了第几个items" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }



    /**
     * 初始化需要循环的View
     * 为了灵活的使用滚动的View，所以把滚动的内容让用户自定义
     * 假如滚动的是三条或者一条，或者是其他，只需要把对应的布局，和这个方法稍微改改就可以了，
     */
    private void setView() {
        for (int i = 0; i < data.size(); i ++) {
            //设置滚动的单个布局
            RelativeLayout moreView = (RelativeLayout) LayoutInflater.from(getActivity()).inflate(R.layout.item_view, null);
            //初始化布局的控件
            TextView tv1 = moreView.findViewById(R.id.tv1);
            //进行对控件赋值
            tv1.setText(data.get(i).toString());
            //添加到循环滚动数组里面去
            views.add(moreView);
        }
    }

    /**
     * 初始化数据
     */
    private void initdata() {
        data = new ArrayList<>();
        data.add("家人给2岁孩子喝这个，孩子智力倒退10岁!!!");
        data.add("iPhone8最感人变化成真，必须买买买买!!!!");
        data.add("简直是白菜价！日本玩家33万甩卖15万张游戏王卡");
        data.add("iPhone7价格曝光了！看完感觉我的腰子有点疼...");
        data.add("主人内疚逃命时没带够，回废墟狂挖30小时！");
//        data.add("竟不是小米乐视！看水抢了骁龙821首发了！！！");

    }
}
