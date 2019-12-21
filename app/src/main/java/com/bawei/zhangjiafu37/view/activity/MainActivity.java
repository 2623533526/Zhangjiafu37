package com.bawei.zhangjiafu37.view.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bawei.zhangjiafu37.R;
import com.bawei.zhangjiafu37.base.mvp.BaseActivity;
import com.bawei.zhangjiafu37.base.mvp.BasePresenter;
import com.bawei.zhangjiafu37.presenter.Presenter;
import com.bawei.zhangjiafu37.view.fragment.Login_Fragment;
import com.bawei.zhangjiafu37.view.fragment.My_Fragment;
import com.bawei.zhangjiafu37.view.fragment.Other_Fragment;
import com.bawei.zhangjiafu37.view.fragment.Peking_Fragment;

import java.util.ArrayList;

public class MainActivity extends BaseActivity<Presenter> implements View.OnClickListener {

    private ViewPager vp;
    private RadioGroup rg;
    private ArrayList<Fragment> fragments;

    @Override
    protected Presenter initPresenter() {
        return new Presenter();
    }

    @Override
    protected void initData() {
        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                rg.check(rg.getChildAt(position).getId());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.bt_login:
                        vp.setCurrentItem(0);
                        break;
                    case R.id.bt_peking:
                        vp.setCurrentItem(1);
                        break;
                    case R.id.bt_my:
                        vp.setCurrentItem(2);
                        break;
                    case R.id.bt_other:
                        vp.setCurrentItem(4);
                        break;
                }
            }
        });
    }

    @Override
    protected void initView() {
        vp = findViewById(R.id.vp);
        rg = findViewById(R.id.rg);
        Login_Fragment fragment_1 = new Login_Fragment();
        Peking_Fragment fragment_2 = new Peking_Fragment();
        My_Fragment fragment_3 = new My_Fragment();
        Other_Fragment fragment_4 = new Other_Fragment();
        fragments = new ArrayList<>();
        fragments.add(fragment_1);
        fragments.add(fragment_2);
        fragments.add(fragment_3);
        fragments.add(fragment_4);
    }

    @Override
    protected int layoutid() {
        return R.layout.activity_main;
    }

    @Override
    public void show() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void success(Object o) {

    }

    @Override
    public void error(Throwable throwable) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }
}
