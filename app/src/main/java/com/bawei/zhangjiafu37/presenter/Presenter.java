package com.bawei.zhangjiafu37.presenter;

import android.util.Log;

import com.bawei.zhangjiafu37.base.contract.Contract;
import com.bawei.zhangjiafu37.base.mvp.BasePresenter;
import com.bawei.zhangjiafu37.model.Model;

/**
 * @author: 张家辅
 * @date: 2019/12/21
 */
public class Presenter extends BasePresenter<Model, Contract.IView> implements Contract.IPresenter{
    @Override
    protected Model initModel() {
        return new Model();
    }

    @Override
    public void Flowsuccess(String string) {
        Log.i("Presenter",string);
        model.Flowsuccess(string, new Contract.IModel.CallBack() {
            @Override
            public void success(Object o) {
                getView().success(o);
            }

            @Override
            public void error(Throwable throwable) {

            }
        });
    }
    @Override
    public void Listsuccess(String string) {
        Log.i("Presenter",string);
        model.Listsuccess(string, new Contract.IModel.CallBack() {
            @Override
            public void success(Object o) {
                getView().success(o);
            }

            @Override
            public void error(Throwable throwable) {

            }
        });
    }

    @Override
    public void error(Throwable throwable) {

    }
}
