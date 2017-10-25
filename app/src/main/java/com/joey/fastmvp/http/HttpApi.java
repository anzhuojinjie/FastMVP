package com.joey.fastmvp.http;


import com.joey.fastmvp.bean.BaseResponse;
import com.joey.fastmvp.ui.test.bean.HomeIndexResponseBean;

import java.util.List;
import java.util.Map;

import okhttp3.MultipartBody;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
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
