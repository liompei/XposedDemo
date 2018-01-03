package com.liompei.xposeddemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Liompei
 * time : 2018/1/3 10:23
 * 1137694912@qq.com
 * https://github.com/liompei
 * remark:
 */

public class MainActivity extends AppCompatActivity {

    private TextView tvTest;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvTest = findViewById(R.id.tv_test);
        tvTest.setText("准备修改的值");
    }
}
