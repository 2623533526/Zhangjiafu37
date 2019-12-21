package com.bawei.zhangjiafu37.diwgets;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * @author: 张家辅
 * @date: 2019/12/21
 */
public class FlowLayout extends ViewGroup {
    public FlowLayout(Context context) {
        super(context);
    }

    public FlowLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FlowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        //初始化变量
        int left=0;
        int top=0;
        int right=0;
        int bottom=0;
        //获得子控件的数量
        int childCount = getChildCount();
        //判断是否小于0
         if(childCount>0){
             //循环遍历获取到控件的索引
             for (int i = 0; i <childCount ; i++) {
                 //获得当前子空间的View
                 View view = getChildAt(i);
                 //测量当前子控件
                 view.measure(0,0);
                 //获取当前子控件的高度
                 int height = view.getMeasuredHeight();
                 //获得当前子控件的宽度
                 int width = view.getMeasuredWidth();
                 //获取当前屏幕的宽度
                 int widthPixels = view.getResources().getDisplayMetrics().widthPixels;
                 right=left+width;
                 if(right>widthPixels-50){
                     left=0;
                     right=left+width;
                     top=bottom+30;
                 }
                 bottom=top+height;
                 view.layout(left,top,right,bottom);
                 left=right+30;


             }
         }
    }
    public void add(final List<String> list){
        if(list.size()>0){
            for (int i = 0; i <list.size() ; i++) {
                final TextView textView = new TextView(getContext());
                textView.setText(list.get(i));
                textView.setTextColor(Color.BLACK);
                addView(textView);
                final int finalI = i;
                textView.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        flowCallBack.success(list.get(finalI));
                    }
                });
            }
        }
    }
    public void addText(final String name){
        TextView textView = new TextView(getContext());
                 textView.setText(name);
                textView.setTextColor(Color.BLACK);
                addView(textView);
                textView.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        flowCallBack.success(name);
                    }
                });
            }


    FlowCallBack flowCallBack;
    public void setFlowCallBack(FlowCallBack flowCallBack) {
        this.flowCallBack = flowCallBack;
    }

    public interface FlowCallBack{
        void success(String name);
    }
}
