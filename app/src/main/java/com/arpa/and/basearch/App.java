package com.arpa.and.basearch;

import androidx.multidex.MultiDexApplication;

import com.arpa.and.basearch.net.ApiService;
import com.arpa.and.basearch.utils.Utils;
import com.king.retrofit.retrofithelper.RetrofitHelper;
import com.scwang.smart.refresh.footer.ClassicsFooter;
import com.scwang.smart.refresh.header.ClassicsHeader;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

import dagger.hilt.android.HiltAndroidApp;

/**
 * author: 李一方(<a href="mailto:leergo@dingtalk.com">leergo@dingtalk.com</a>)<br/>
 * version: 1.0.0<br/>
 * since: 2021-04-22 1:08 PM
 *
 * <p>
 * 全局 App
 * </p>
 */
@HiltAndroidApp
public class App extends MultiDexApplication {
    static {
        //设置全局的Header构建器
        SmartRefreshLayout.setDefaultRefreshHeaderCreator((context, layout) -> {
            layout.setPrimaryColorsId(android.R.color.transparent, R.color.grey);//全局设置主题颜色
            return new ClassicsHeader(context);//.setTimeFormat(new DynamicTimeFormat("更新于 %s"));//指定为经典Header，默认是 贝塞尔雷达Header
        });
        //设置全局的Footer构建器
        SmartRefreshLayout.setDefaultRefreshFooterCreator((context, layout) -> {
            //指定为经典Footer，默认是 BallPulseFooter
            layout.setPrimaryColorsId(android.R.color.transparent, R.color.grey);//全局设置主题颜色
            return new ClassicsFooter(context).setDrawableSize(20);
        });
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Utils.init(this);
        setApiURL();
    }

    private void setApiURL() {
        RetrofitHelper.getInstance().setBaseUrl(ApiService.API.URL_WMS);
        // RetrofitHelper.getInstance().putDomain(API.URL_KEY, API.URL_AUTH);
    }
}
