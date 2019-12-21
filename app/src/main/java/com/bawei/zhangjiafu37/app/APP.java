package com.bawei.zhangjiafu37.app;

import android.app.Application;
import android.content.Context;

import com.bawei.zhangjiafu37.base.contract.Contract;
import com.bawei.zhangjiafu37.dispose.MyDisPose;

/**
 * @author: 张家辅
 * @date: 2019/12/21
 */
public class APP extends Application {
   public static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context=getApplicationContext();
        MyDisPose myDisPose = new MyDisPose();
        Thread.setDefaultUncaughtExceptionHandler(myDisPose);
    }

    public static Context getcontext() {
        return context;
    }
}
