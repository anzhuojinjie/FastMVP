package com.joey.loanmarket.http;


import com.joey.loanmarket.bean.BaseResponse;
import com.joey.loanmarket.ui.test.bean.HomeIndexResponseBean;

import retrofit2.http.GET;
import rx.Observable;

/**
 * 创建时间： 2017/10/25.
 * 创 建 人：   joey.
 * 功能描述：
 */
public interface HttpApi {

    //所有需要的泛型 添加：BaseResponse<UserInfo>
    //首页
    @GET("credit-app/index")
    Observable<BaseResponse<HomeIndexResponseBean>> index();


}
