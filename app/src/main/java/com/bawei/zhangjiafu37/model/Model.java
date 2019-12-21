package com.bawei.zhangjiafu37.model;

import android.util.Log;

import com.bawei.zhangjiafu37.base.contract.Contract;
import com.bawei.zhangjiafu37.entity.FlowEntity;
import com.bawei.zhangjiafu37.entity.ListEntity;
import com.bawei.zhangjiafu37.utlis.VolleyUtils;
import com.google.gson.Gson;

/**
 * @author: 张家辅
 * @date: 2019/12/21
 */
public class Model implements Contract.IModel {
    @Override
    public void Flowsuccess(String string, final CallBack callBack) {
        Log.i("Model",string);
        VolleyUtils.getInstance().doGet(string, new VolleyUtils.CallBack() {
            @Override
            public void success(String name) {
                Gson gson = new Gson();
                FlowEntity flowEntity = gson.fromJson(name, FlowEntity.class);
                callBack.success(flowEntity);
            }

            @Override
            public void error(Throwable throwable) {
            callBack.error(throwable);
            }
        });
    }

    @Override
    public void Listsuccess(String string, final CallBack callBack) {
        Log.i("Model",string);
        VolleyUtils.getInstance().doGet(string, new VolleyUtils.CallBack() {
            @Override
            public void success(String name) {
                Gson gson = new Gson();
                ListEntity listEntity = gson.fromJson(name, ListEntity.class);
                callBack.success(listEntity);
            }

            @Override
            public void error(Throwable throwable) {
                callBack.error(throwable);
            }
        });
    }

    @Override
    public void error() {

    }
}
