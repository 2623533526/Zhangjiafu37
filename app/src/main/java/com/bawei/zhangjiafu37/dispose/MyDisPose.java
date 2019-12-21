package com.bawei.zhangjiafu37.dispose;

import android.util.Log;

import androidx.annotation.NonNull;

/**
 * @author: 张家辅
 * @date: 2019/12/21
 */
public class MyDisPose implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(@NonNull Thread t, @NonNull Throwable e) {
        Log.i("xxx",e.getMessage());
    }
}
