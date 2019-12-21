package com.bawei.zhangjiafu37.view.fragment;

import android.view.View;

import com.bawei.zhangjiafu37.R;
import com.bawei.zhangjiafu37.base.contract.Contract;
import com.bawei.zhangjiafu37.base.mvp.BaseFragment;
import com.bawei.zhangjiafu37.presenter.Presenter;

/**
 * @author: 张家辅
 * @date: 2019/12/21
 */
public class Other_Fragment extends BaseFragment<Presenter> implements Contract.IView {
    @Override
    protected Presenter initPresenter() {
        return new Presenter();
    }

    @Override
    protected void initView(View inflate) {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected int layoutid() {
        return R.layout.other_fragment;
    }

    @Override
    public void show() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void success(Object o) {

    }

    @Override
    public void error(Throwable throwable) {

    }
}
