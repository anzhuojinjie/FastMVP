package com.joey.fastmvp.ui.main.activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;
import com.joey.fastmvp.R;
import com.joey.fastmvp.base.BaseActivity;
import com.joey.fastmvp.ui.home.fragment.HomeFragment;
import com.joey.fastmvp.ui.information.fragment.InformationFragment;
import com.joey.fastmvp.ui.loan.fragment.LoanFragment;
import com.joey.fastmvp.ui.main.bean.Tab;
import com.joey.fastmvp.ui.my.fragment.MyFragment;
import com.joey.fastmvp.widget.FragmentTabHost;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity {
    @BindView(android.R.id.tabhost)
    FragmentTabHost mTabhost;

    private LayoutInflater mInflater;
    private List<Tab> mTabs = new ArrayList<>();
    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void loadData() {
        initTab();
    }

    private void initTab() {
        Tab tab_home = new Tab(HomeFragment.class,R.string.tab_mian,R.drawable.bottom_msg_selector);
        Tab tab_loan = new Tab(LoanFragment.class,R.string.tab_loan,R.drawable.bottom_msg_selector);
        Tab tab_information = new Tab(InformationFragment.class,R.string.tab_information,R.drawable.bottom_msg_selector);
        Tab tab_my = new Tab(MyFragment.class,R.string.tab_my,R.drawable.bottom_msg_selector);

        mTabs.add(tab_home);
        mTabs.add(tab_loan);
        mTabs.add(tab_information);
        mTabs.add(tab_my);

        mInflater = LayoutInflater.from(this);
        mTabhost = (FragmentTabHost) this.findViewById(android.R.id.tabhost);
        mTabhost.setup(this,getSupportFragmentManager(),R.id.realtabcontent);

        for (Tab tab : mTabs){
            TabHost.TabSpec tabSpec = mTabhost.newTabSpec(getString(tab.getTitle()));
            tabSpec.setIndicator(buildIndicator(tab));
            mTabhost.addTab(tabSpec,tab.getFragment(),null);
        }

        mTabhost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
            }
        });

        mTabhost.getTabWidget().setShowDividers(LinearLayout.SHOW_DIVIDER_NONE);
    }





    private  View buildIndicator(Tab tab){
        View view =mInflater.inflate(R.layout.tab_indicator,null);
        ImageView img = view.findViewById(R.id.icon_tab);
        TextView text = view.findViewById(R.id.txt_indicator);
        img.setBackgroundResource(tab.getIcon());
        text.setText(tab.getTitle());
        return  view;
    }
}
