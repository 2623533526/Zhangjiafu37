package com.bawei.zhangjiafu37.base.mvp;

import java.lang.ref.WeakReference;

/**
 * @author: 张家辅
 * @date: 2019/12/21
 */
public abstract class BasePresenter<M extends IBaseModel,V extends IBaseView>{
   public M  model;
   public WeakReference<V> weakReference;

    public BasePresenter() {
        model=initModel();
    }
    public void attach(V v){
        weakReference = new WeakReference<V>(v);
    }
    public void detach(){
        if(weakReference!=null){
            weakReference.clear();
            weakReference=null;
        }
    }
    public V getView(){
        return weakReference.get();
    }

    protected abstract M initModel();
}
