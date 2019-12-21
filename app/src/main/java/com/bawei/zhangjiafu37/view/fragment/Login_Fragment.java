package com.bawei.zhangjiafu37.view.fragment;

import android.content.Intent;
import android.nfc.tech.NfcA;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.zhangjiafu37.Main2Activity;
import com.bawei.zhangjiafu37.R;
import com.bawei.zhangjiafu37.base.contract.Contract;
import com.bawei.zhangjiafu37.base.mvp.BaseFragment;
import com.bawei.zhangjiafu37.diwgets.FlowLayout;
import com.bawei.zhangjiafu37.entity.FlowEntity;
import com.bawei.zhangjiafu37.entity.ListEntity;
import com.bawei.zhangjiafu37.presenter.Presenter;
import com.bawei.zhangjiafu37.utlis.MyRecy;
import com.bawei.zhangjiafu37.view.activity.MainActivity;

import java.net.URLEncoder;
import java.util.List;

/**
 * @author: 张家辅
 * @date: 2019/12/21
 */
public class Login_Fragment extends BaseFragment<Presenter> implements Contract.IView {

    private EditText login_goods;
    private Button login_search;
    private FlowLayout flow;
    private RecyclerView recyclerViewv;

    @Override
    protected Presenter initPresenter() {
        return new Presenter();
    }

    @Override
    protected void initView(View inflate) {
        login_goods = inflate.findViewById(R.id.login_goods);
        login_search = inflate.findViewById(R.id.login_search);
        flow = inflate.findViewById(R.id.flow);
        flow.setFlowCallBack(new FlowLayout.FlowCallBack() {
            @Override
            public void success(String name) {
                login_goods.setText(name);
                login_goods.setSelection(name.length());
                presenter.Listsuccess("http://172.17.8.100/small/commodity/v1/findCommodityByKeyword?keyword="+URLEncoder.encode(name)+"&page=1&count=5");
            }
        });
        recyclerViewv = inflate.findViewById(R.id.rv);
        recyclerViewv.setLayoutManager(new GridLayoutManager(getActivity(),2));
        login_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = login_goods.getText().toString();
                flow.addText(s);
                presenter.Listsuccess("http://172.17.8.100/small/commodity/v1/findCommodityByKeyword?keyword="+URLEncoder.encode(s)+"&page=1&count=5");
            }
        });
    }

    @Override
    protected void initData() {
     presenter.Flowsuccess("http://blog.zhaoliang5156.cn/baweiapi/"+ URLEncoder.encode("手机"));
    }

    @Override
    protected int layoutid() {
        return R.layout.login_fragment;
    }


    @Override
    public void show() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void success(Object o) {
     if(o instanceof FlowEntity){
         FlowEntity flowEntity =(FlowEntity)o;
         Log.i("View",flowEntity.toString());
         flow.add(flowEntity.getTags());
     }else if(o instanceof ListEntity){
         ListEntity listEntity =(ListEntity)o;
         List<ListEntity.resule> resules=listEntity.getResult();
         MyRecy myRecy = new MyRecy(getActivity(), resules);
         myRecy.setCallBack(new MyRecy.CallBack() {
             @Override
             public void success() {
                 Intent intent = new Intent(getContext(), Main2Activity.class);
                 startActivity(intent);
             }
         });
         recyclerViewv.setAdapter(myRecy);
     }
    }

    @Override
    public void error(Throwable throwable) {

    }
}
