package com.joey.loanmarket.ui.test.presenter;

import com.joey.loanmarket.base.BasePresenter;
import com.joey.loanmarket.http.HttpManager;
import com.joey.loanmarket.http.HttpSubscriber;
import com.joey.loanmarket.ui.test.bean.HomeIndexResponseBean;
import com.joey.loanmarket.ui.test.contract.MainContract;

/**
 * 创建时间： 2017/10/25.
 * 创 建 人：   joey.
 * 功能描述：
 */

public class MainPresenter  extends BasePresenter<MainContract.View> implements MainContract.Presenter{

    public final String TYPE_INDEX = "index";

    @Override
    public void loadIndex() {
        toSubscribe(HttpManager.getApi().index(), new HttpSubscriber<HomeIndexResponseBean>() {
            @Override
            public void _onStart() {
                mView.showLoading("加载中...");
            }

            @Override
            protected void _onNext(HomeIndexResponseBean homeIndexResponseBean) {
                if (homeIndexResponseBean==null||homeIndexResponseBean.getItem()==null){
                    mView.showErrorMsg("获取信息失败,请稍后重新",TYPE_INDEX);
                }else{
                    mView.indexSuccess(homeIndexResponseBean);
                }
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorMsg(message,TYPE_INDEX);
            }

            @Override
            protected void _onCompleted() {
                mView.stopLoading();
            }
        });
    }
}
