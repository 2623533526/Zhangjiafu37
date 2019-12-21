package com.bawei.zhangjiafu37.js;

import android.util.Log;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

import com.bawei.zhangjiafu37.app.APP;

/**
 * @author: 张家辅
 * @date: 2019/12/21
 */
public class jsToAndroid {
    @JavascriptInterface
    public void js1() {
        Toast.makeText(APP.getcontext(), "这是js传到Android的无参方法", Toast.LENGTH_SHORT).show();
    }
    @JavascriptInterface
    public void js2(String name) {
        Toast.makeText(APP.getcontext(), "这是js传到Android的有参方法", Toast.LENGTH_SHORT).show();
    }
}
