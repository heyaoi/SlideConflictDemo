package com.example.slideconflictdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;
import android.widget.ScrollView;

public class TestScollerview extends ScrollView {
    private int mLastYIntercept;

    public TestScollerview(Context context) {
        super(context);
    }

    public TestScollerview(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TestScollerview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean intercepted = false;
        int y = (int) ev.getY();
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                intercepted = false;
                break;
            case MotionEvent.ACTION_MOVE:{
                ListView listView = (ListView) getChildAt(1);
                break;
            }
            case MotionEvent.ACTION_UP:
                intercepted = false;
                break;
            default:
                break;
        }


        mLastYIntercept = y;

        return intercepted;
    }
}
