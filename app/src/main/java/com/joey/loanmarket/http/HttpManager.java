package com.joey.loanmarket.http;


import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.joey.loanmarket.app.App;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.JavaNetCookieJar;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * 创建时间： 2017/10/25.
 * 创 建 人：   joey.
 * 功能描述：
 */
public class HttpManager {

    private HttpApi mHttpApi;

    private static HttpManager instance = null;

    /**
     * 获取单例
     *
     * @return 实例
     */
    public static HttpManager getInstance() {

        if (instance == null) {
            instance = new HttpManager();
            return instance;
        }
        return instance;
    }

    public static HttpApi getApi() {
        return getInstance().mHttpApi;
    }

    private HttpManager() {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(App.getConfig().getBaseUrl())
                .client(createOkHttpClient())
                //.addConverterFactory(ScalarsConverterFactory.create()) 返回类型转成String
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        mHttpApi = retrofit.create(HttpApi.class);
    }

    public OkHttpClient createOkHttpClient() {

        Cache cache = new Cache(new File(App.getContext().getCacheDir(), "qbmCache"),
                1024 * 1024 * 100);

        //添加全局统一请求头
        Interceptor headerInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request.Builder builder = chain.request().newBuilder();
                //TODO 请求头添加sessionid
                /*String sessionid = SpUtil.getString(Constant.CACHE_TAG_SESSIONID);
                if (App.getConfig().getLoginStatus()&&!TextUtils.isEmpty(sessionid)){
                    builder.addHeader("Cookie", "SESSIONID="+sessionid);
                }*/
                Response response = chain.proceed(builder.build());
                return response;
            }
        };
        //添加全局统一请求参数
        Interceptor paramsInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                HttpUrl httpUrl = request.url();
                HttpUrl url = httpUrl.newBuilder()
                        .addQueryParameter("clientType", "android").build();
                        /*TODO 为请求添加统一的参数
                        .addQueryParameter("appVersion", ViewUtil.getAppVersion(App.getContext()))
                        .addQueryParameter("deviceId", ViewUtil.getDeviceId(App.getContext()))
                        .addQueryParameter("mobilePhone", App.getConfig().getLoginStatus()?SpUtil.getString(Constant.CACHE_TAG_USERNAME):"")
                        .addQueryParameter("deviceName", ViewUtil.getDeviceName().trim())
                        .addQueryParameter("osVersion", ViewUtil.getOsVersion())
                        .addQueryParameter("appName", "mld")
                        .addQueryParameter("appMarket", App.getConfig().getChannelName()).build();*/
                Request.Builder builder = request.newBuilder().url(url);
                Response response = chain.proceed(builder.build());
                return response;
            }
        };
        //是否显示"请求繁忙"倒计时dialog  PS：需要显示的在HttpApi接口添加请求头@Headers("showDialog:true")
        Interceptor showDialogInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                String showDialog = request.header("showDialog");
                Response response = chain.proceed(chain.request());
                String body=response.body().string();
                JSONObject jsonResponse = null;
                try {
                    jsonResponse=new JSONObject(body);
                    String code = jsonResponse.getString("code");
                    if ("-3".equals(code)){//需与服务器协商,返回-3
                        if (TextUtils.isEmpty(showDialog)||!showDialog.equals("true")){
                            jsonResponse.put("code","-1");
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return response.newBuilder().body( ResponseBody.create(MediaType.parse("UTF-8"),jsonResponse.toString())).build();
            }
        };
        //日志拦截器
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                //TODO 可以添加log将message打印出来
            }
        });
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        //CookieManager管理器
        CookieManager cookieManager = new CookieManager();
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);

        OkHttpClient mOkHttpClient = new OkHttpClient.Builder()
                .cache(cache)   //缓存
                .addInterceptor(headerInterceptor)
                .addInterceptor(paramsInterceptor)
                .addInterceptor(showDialogInterceptor)
                .cookieJar(new JavaNetCookieJar(cookieManager))//设置持续化cookie
                .addInterceptor(logging)    //打印日志
                .retryOnConnectionFailure(true)//失败重连
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .build();
        return mOkHttpClient;
    }

    /**
     * 给url添加全局统一请求参数信息
     * @param url
     * @return
     */
    public static String getUrl(String url) {
//        if (TextUtils.isEmpty(url)) {
//            return "";
//        }
//        String ret_url = "";
//        if(url.contains("clientType=android&appVersion=")){
//
//            return url;
//        }
//        else{
//            if (url.contains("?")) {
//                ret_url = url + "&";
//            } else {
//                ret_url = url + "?";
//            }
//            ret_url += "clientType=android&"
//                    +"appVersion="+ ViewUtil.getAppVersion(App.getContext())
//                    + "&deviceId="+ ViewUtil.getDeviceId(App.getContext())
//                    + "&mobilePhone="+(App.getConfig().getLoginStatus()?SpUtil.getString(Constant.CACHE_TAG_USERNAME):"")
//                    + "&deviceName=" + ViewUtil.getDeviceName() + "&osVersion="
//                    + ViewUtil.getOsVersion() + "&appMarket="
//                    + App.getConfig().getChannelName()+"&appName=mld";
//            return ret_url.replace(" ", "");
//        }
        return url;
    }

    /**
     * 处理线程调度
     *
     * @param <T>
     * @return
     */
    public <T> Observable.Transformer<T, T> applySchedulers() {
        return new Observable.Transformer<T, T>() {
            @Override
            public Observable<T> call(Observable<T> tObservable) {
                return tObservable
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .unsubscribeOn(Schedulers.io());
            }
        };
    }
}
