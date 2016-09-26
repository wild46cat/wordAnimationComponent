package com.example.administrator.wordanimationcomponent;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.GetChars;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ViewAnimator;

/**
 * Created by Administrator on 2016-09-26.
 */
public class ViewAnimatorWordComponent extends RelativeLayout {
    private ViewAnimator viewAnimator;
    private final int MSG_CODE = 0x667;
    private final int TIMER_INTERVAL = 3000;
    private String[] strings;

    public void setStrings(String[] strings) {
        this.strings = strings;
        if(strings != null){
            for (int i = 0; i < strings.length; i++) {
                TextView textView = new TextView(getContext());
                textView.setText(strings[i]);
                //任意设置你的文字样式，在这里
                textView.setTextColor(getResources().getColor(android.R.color.holo_purple));
                textView.setTextSize(30);
                viewAnimator.addView(textView,i);
            }
        }
    }

    public ViewAnimatorWordComponent(Context context, AttributeSet attrs) {
        super(context, attrs);
        viewAnimator = new ViewAnimator(getContext());
        viewAnimator.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        addView(viewAnimator);
        Message message = handler.obtainMessage(MSG_CODE);
        handler.sendMessageDelayed(message,TIMER_INTERVAL);
    }

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == MSG_CODE){
                viewAnimator.setOutAnimation(getContext(),R.anim.slide_out_up);
                viewAnimator.setInAnimation(getContext(),R.anim.slide_in_down);
                viewAnimator.showNext();
                Message message = handler.obtainMessage(MSG_CODE);
                handler.sendMessageDelayed(message,TIMER_INTERVAL);
            }
        }
    };

}
