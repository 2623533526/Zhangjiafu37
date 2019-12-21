package com.bawei.zhangjiafu37.utlis;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bawei.zhangjiafu37.app.APP;

import java.util.Map;

/**
 * @author: 张家辅
 * @date: 2019/12/21
 */
public class VolleyUtils{
    private static VolleyUtils volleyUtils;
    private final RequestQueue requestQueue;

    public VolleyUtils() {
        requestQueue = Volley.newRequestQueue(APP.getcontext());
    }

    public static VolleyUtils getInstance() {
        if(volleyUtils==null){
            synchronized (VolleyUtils.class){
                if(volleyUtils==null){
                    volleyUtils=new VolleyUtils();
                }
            }
        }
        return volleyUtils;
    }
    public void doGet(String URL, final CallBack callBack){
        StringRequest stringRequest = new StringRequest(URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
             callBack.success(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callBack.error(error);
            }
        });
        requestQueue.add(stringRequest);
    }
    public void doPost(String URL, final Map<String,String> map, final CallBack callBack){
        StringRequest stringRequest = new StringRequest(URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
             callBack.success(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            callBack.error(error);
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return map;
            }
        };
        requestQueue.add(stringRequest);
    }
    CallBack callBack;

    public void setCallBack(CallBack callBack) {
        this.callBack = callBack;
    }

    public interface CallBack{
        void success(String name);
        void error(Throwable throwable);
    }
}
