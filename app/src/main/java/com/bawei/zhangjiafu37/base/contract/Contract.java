package com.bawei.zhangjiafu37.base.contract;

import com.bawei.zhangjiafu37.base.mvp.IBaseModel;
import com.bawei.zhangjiafu37.base.mvp.IBaseView;

/**
 * @author: 张家辅
 * @date: 2019/12/21
 */
public class Contract {
   public interface IView extends IBaseView {
        void success(Object o);
        void error(Throwable throwable);
    }
   public interface IModel extends IBaseModel {
        void Flowsuccess(String string,CallBack callBack);
       void Listsuccess(String string,CallBack callBack);
        void error();
        interface CallBack{
            void success(Object object);
            void error(Throwable throwable);
        }
    }
   public interface IPresenter{
        void Flowsuccess(String string);
        void Listsuccess(String string);
        void error(Throwable throwable);
    }
}
