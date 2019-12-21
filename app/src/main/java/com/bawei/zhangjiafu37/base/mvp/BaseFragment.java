package com.bawei.zhangjiafu37.base.mvp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bawei.zhangjiafu37.R;
import com.bawei.zhangjiafu37.base.contract.Contract;

/**
 * @author: 张家辅
 * @date: 2019/12/21
 */
public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements Contract.IView {
    public P presenter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(layoutid(), container, false);
        initView(inflate);
        presenter=initPresenter();
        presenter.attach(this);
        return inflate;
    }

    protected abstract P initPresenter();

    protected abstract void initView(View inflate);

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();

    }

    protected abstract void initData();

    protected abstract int layoutid();
}
