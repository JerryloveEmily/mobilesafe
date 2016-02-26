package com.jerry.mobilesafe.api.network;

import android.util.Log;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;

import java.lang.reflect.Type;

/**
 * Get方式网络请求
 * Created by Jerry on 2015/5/4.
 */
public class GetObjectRequest<T> extends Request<T> {

    private static final String TAG = "GetObjectRequest";

    private Gson mGson;
    private Response.Listener<T> mListener;
    private Type mClazz;

    public GetObjectRequest(String url, Type type, Response.Listener<T> listener,
                            Response.ErrorListener errorListener) {
        super(Method.GET, url, errorListener);
        mListener = listener;
        mClazz = type;
        mGson = new Gson();
    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {

        /*{
" +
                    "      \"recordId\":\"12315\", \n" +
                    "      \"time\":\"2016年02月12日 10:30:20\", \n" +
                    "      \"address\":\"厦门市思明区观日路\", \n" +
                    "      \"longitude\":180.236, \n" +
                    "      \"latitude\":60.2365," +
                    "       \"photos\":[ \n" +
                    "        \"http://img5.imgtn.bdimg.com/it/u=2413936690,143569795&fm=21&gp=0.jpg\", \n" +
                    "        \"http://img4.imgtn.bdimg.com/it/u=351229423,2450736669&fm=21&gp=0.jpg\", \n" +
                    "        \"http://img4.imgtn.bdimg.com/it/u=1238464357,3414670591&fm=21&gp=0.jpg\" \n" +
                    "      ] \n" +
                    "    }, \n" +
                    "    { \n" +
                    "      \"recordId\":\"136523\", \n" +
                    "      \"time\":\"2015年10月16日 10:30:20\", \n" +
                    "      \"address\":\"厦门市湖里区嘉禾路\", \n" +
                    "      \"longitude\":180.236, \n" +
                    "      \"latitude\":60.2365," +
                    "      \"photos\":[ \n" +
                    "        \"http://img5.imgtn.bdimg.com/it/u=2413936690,143569795&fm=21&gp=0.jpg\", \n" +
                    "        \"http://img4.imgtn.bdimg.com/it/u=351229423,2450736669&fm=21&gp=0.jpg\", \n" +
                    "        \"http://img4.imgtn.bdimg.com/it/u=1238464357,3414670591&fm=21&gp=0.jpg\" \n" +
                    "      ] \n" +
                    "    }*/

        try {
            T result;
            String jsonString = "{\"eventCode\": \"0\", \"msg\":\"success\", \"objList\":[" +
                    "{\n" +
                    "      \"articleId\":\"123\",\n" +
                    "      \"title\":\"常见的车险种类及其介绍\",\n" +
                    "      \"summary\":\"都来认识一下常见的车险吧，买了车的更是要了解哟~❤，大家可以记在记事本里防止忘记哟~❤\",\n" +
                    "      \"thumbnailUrl\":\"http://img2.imgtn.bdimg.com/it/u=250959748,997140814&fm=21&gp=0.jpg\",\n" +
                    "      \"contentUrl\":\"http://chexian.baike.com/article-1801705.html\",\n" +
                    "      \"isFavorite\":-1\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"articleId\":\"124\",\n" +
                    "      \"title\":\"交强险\",\n" +
                    "      \"summary\":\"2006年7月1日起全国统一开始实行交强险，它是“机动车交通事故责任强制保险”的简称，是一份机动车辆必须购买的强制保险，由保险公司对被保险机动车发生道路交通事故造成受害人（不包括本车人员）的人身伤亡、财产损失，在责任限额内予以赔偿。\",\n" +
                    "      \"thumbnailUrl\":\"http://img2.imgtn.bdimg.com/it/u=250959748,997140814&fm=21&gp=0.jpg\",\n" +
                    "      \"contentUrl\":\"http://chexian.baike.com/article-1801705.html\",\n" +
                    "      \"isFavorite\":-1\n" +
                    "    }" +
                    "] }";
//            String jsonString = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
            Log.d(TAG, "jsonString = " + jsonString);
            result = mGson.fromJson(jsonString, mClazz);
            Log.d(TAG, "result = " + result.toString());
            switch (1){
                case 1:
                    break;
                default:
                    break;
            }
            return Response.success(result, HttpHeaderParser.parseCacheHeaders(response));
        } catch (Exception e) {
            return Response.error(new VolleyError(e));
        }
    }

     @Override
    protected void deliverResponse(T response) {
        mListener.onResponse(response);
    }
}
