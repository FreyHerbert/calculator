package com.example.leiyun.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by LeiYun on 2016/8/16 0016.
 */
public class MainActivity extends Activity implements View.OnClickListener{
    TextView view;
    Button drop, symbol, percent, division;
    Button seven, eight, nine, multiply;
    Button four, five, six, minus;
    Button one, two, three, add;
    Button zero, point, equal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main);
        //显示框
        view = (TextView) findViewById(R.id.view);

        /**
         * 界面第一行控件的注册
         */
        drop = (Button) findViewById(R.id.button_AC);
        symbol = (Button) findViewById(R.id.button_Symbol);
        percent = (Button) findViewById(R.id.button_Percent);
        division = (Button) findViewById(R.id.button_Division);
        //注册点击事件
        drop.setOnClickListener(this);
        symbol.setOnClickListener(this);
        percent.setOnClickListener(this);
        division.setOnClickListener(this);

        /**
         * 界面第二行控件的注册
         */
        seven = (Button) findViewById(R.id.button_Seven);
        eight = (Button) findViewById(R.id.button_Eight);
        nine = (Button) findViewById(R.id.button_Nine);
        multiply = (Button) findViewById(R.id.button_Multiply);
        //注册点击事件
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        multiply.setOnClickListener(this);

        /**
         * 界面第三行控件的注册
         */
        four = (Button) findViewById(R.id.button_Four);
        five = (Button) findViewById(R.id.button_Five);
        six = (Button) findViewById(R.id.button_Six);
        minus = (Button) findViewById(R.id.button_Minus);
        //注册点击事件
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        minus.setOnClickListener(this);

        /**
         * 界面第四行控件的注册
         */
        one = (Button) findViewById(R.id.button_One);
        two = (Button) findViewById(R.id.button_Two);
        three = (Button) findViewById(R.id.button_Three);
        add = (Button) findViewById(R.id.button_Add);
        //注册点击事件
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        add.setOnClickListener(this);

        /**
         * 界面第五行控件的注册
         */
        zero = (Button) findViewById(R.id.button_Zero);
        point = (Button) findViewById(R.id.button_Point);
        equal = (Button) findViewById(R.id.button_Equal);
        //注册点击事件
        zero.setOnClickListener(this);
        point.setOnClickListener(this);
        equal.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_AC:
                break;
            case R.id.button_Symbol:
                break;
            case R.id.button_Percent:
                break;
            case R.id.button_Division:
                break;

            case R.id.button_Seven:
                break;
            case R.id.button_Eight:
                break;
            case R.id.button_Nine:
                break;
            case R.id.button_Multiply:
                break;

            case R.id.button_Four:
                break;
            case R.id.button_Five:
                break;
            case R.id.button_Six:
                break;
            case R.id.button_Minus:
                break;

            case R.id.button_One:
                break;
            case R.id.button_Two:
                break;
            case R.id.button_Three:
                break;

            case R.id.button_Zero:
                break;
            case R.id.button_Point:
                break;
            case R.id.button_Equal:
                break;
        }
    }
}
