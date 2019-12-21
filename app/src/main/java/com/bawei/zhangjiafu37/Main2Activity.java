package com.bawei.zhangjiafu37;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.bawei.zhangjiafu37.base.mvp.BaseActivity;
import com.bawei.zhangjiafu37.js.jsToAndroid;
import com.bawei.zhangjiafu37.presenter.Presenter;

public class Main2Activity extends BaseActivity<Presenter> {

    private WebView web;

    @Override
    protected Presenter initPresenter() {
        return new Presenter();
    }

    @Override
    protected void initData() {
    }

    @Override
    protected void initView() {
        web = findViewById(R.id.web);
        web.getSettings().setJavaScriptEnabled(true);
        web.loadUrl("file:///android_asset/js.html");
        web.addJavascriptInterface(new jsToAndroid(),"a");
        web.setWebViewClient(new WebViewClient());
    }

    @Override
    protected int layoutid() {
        return R.layout.activity_main2;
    }

    @Override
    public void success(Object o) {

    }

    @Override
    public void error(Throwable throwable) {

    }

    @Override
    public void show() {

    }

    @Override
    public void hide() {

    }

    public void bt1(View view) {
        web.loadUrl("JavaScript:name()");
    }

    public void bt2(View view) {
        String name=5+"";
        web.loadUrl("JavaScript:age('"+name+"')");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }
}
