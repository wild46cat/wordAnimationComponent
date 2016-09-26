package com.example.administrator.wordanimationcomponent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private ViewAnimatorWordComponent viewAnimatorWordComponent;
    private String[] strings = new String[]{
            "如果你真想得到一些知识",
            "最好过滤一下你的信息",
            "否则你只是在别人的思考中",
            "得意着——《暗时间》"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewAnimatorWordComponent = (ViewAnimatorWordComponent)this.findViewById(R.id.wordAnimator);
        viewAnimatorWordComponent.setStrings(strings);
    }
}
