package com.joey.loanmarket.ui.test.contract;

import com.joey.loanmarket.base.BaseView;
import com.joey.loanmarket.ui.test.bean.HomeIndexResponseBean;

/**
 * 创建时间： 2017/10/25.
 * 创 建 人：   joey.
 * 功能描述：
 */

public interface MainContract {
    interface View extends BaseView {
        void indexSuccess(HomeIndexResponseBean result);
    }
    interface Presenter{
        /**
         * 首页数据
         */
        void loadIndex();
    }
}
