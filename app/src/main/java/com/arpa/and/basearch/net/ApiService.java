package com.arpa.and.basearch.net;


import com.arpa.and.basearch.bean.base.Result;
import com.arpa.and.basearch.bean.res.ResLogin;
import com.arpa.and.basearch.bean.res.ResWarehouse;
import com.arpa.and.basearch.utils.Const.AppConfig;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {

    /**
     * 获取仓库
     */
    @Headers({"client_id: " + AppConfig.clientID, "client_secret: " + AppConfig.clientSecret})
    @GET(API.API_WAREHOUSE_AUTHORIZATION)
    Call<Result<List<ResWarehouse>>> getWarehouseWithoutAuth(@Query("userLoginId") String loginID);

    /**
     * 获取认证
     */
    // @DomainName(API.URL_KEY)
    @POST(API.API_AUTHORIZATION)
    @FormUrlEncoded
    Call<Result<ResLogin>> authorize(@FieldMap Map<String, Object> data);

    /**
     * API 请求地址、一些参数
     */
    interface API {
        String URL_KEY = "API-AUTH";

        /**
         * 仓储服务 API 服务地址
         */
        //  String URL_WMS = "http://192.168.31.166/"; // 夏宝新
        //  String URL_WMS = "http://192.168.30.190/"; // 邵朱尧
        //  String URL_WMS = "http://192.168.30.61/"; // 李一方
        String URL_WMS = "http://49.4.71.215/"; // 标准版开发测试
        //  String URL_WMS = "http://192.168.31.144/"; // 508 内部服务器（原徐杨）

        /**
         * API：获取仓库
         */
        String API_WAREHOUSE_AUTHORIZATION = "wms/warehouse/warehouseAuthorization";
        /**
         * API：获取认证
         */
        String API_AUTHORIZATION = "arpa-basic-api/authorize";
    }
}
