package com.example.leiyun.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

/**
 * Created by LeiYun on 2016/8/16 0016.
 */
public class MainActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main);
    }
}
