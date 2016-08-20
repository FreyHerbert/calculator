package com.example.leiyun.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by LeiYun on 2016/8/16 0016.
 */
public class MainActivity extends Activity implements View.OnClickListener{
    private TextView view;
    private Button drop, symbol, percent, division;
    private Button seven, eight, nine, multiply;
    private Button four, five, six, minus;
    private Button one, two, three, add;
    private Button zero, point, equal;
    private NumberOperate numberOperate = new NumberOperate();
    private StringBuilder showBuff = new StringBuilder(); //用于数字连续输入时进行缓冲
    private List<String> numberList = new LinkedList<String>(); //数字栈
    private List<String> operateSymbol = new LinkedList<String>(); //符号栈


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main);
        //显示框
        view = (TextView) findViewById(R.id.view);
        view.setText("0");
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
                showBuff.setLength(0);
                view.setText("0");
                break;
            case R.id.button_Symbol:
                if(showBuff.length() != 0) {
                    String s = numberOperate.
                            symbolTranslate(showBuff.toString());
                    showBuff.setLength(0);
                    showBuff.append(s);
                    view.setText(showBuff.toString());
                }
                break;
            case R.id.button_Percent:
                break;
            case R.id.button_Division:
                break;

            case R.id.button_Seven:
                showBuff.append("7");
                view.setText(showBuff.toString());
                break;
            case R.id.button_Eight:
                showBuff.append("8");
                view.setText(showBuff.toString());
                break;
            case R.id.button_Nine:
                showBuff.append("9");
                view.setText(showBuff.toString());
                break;
            case R.id.button_Multiply:
                break;

            case R.id.button_Four:
                showBuff.append("4");
                view.setText(showBuff.toString());
                break;
            case R.id.button_Five:
                showBuff.append("5");
                view.setText(showBuff.toString());
                break;
            case R.id.button_Six:
                showBuff.append("6");
                view.setText(showBuff.toString());
                break;
            case R.id.button_Minus:
                break;

            case R.id.button_One:
                showBuff.append("1");
                view.setText(showBuff.toString());
                break;
            case R.id.button_Two:
                showBuff.append("2");
                view.setText(showBuff.toString());
                break;
            case R.id.button_Three:
                showBuff.append("3");
                view.setText(showBuff.toString());
                break;

            case R.id.button_Zero:
                if (view.getText().charAt(0) == '0')
                    view.setText("0");
                else {
                    showBuff.append("0");
                    view.setText(showBuff.toString());
                }
                break;
            case R.id.button_Point:
                if (showBuff.length() == 0) {
                    showBuff.append("0.");
                }else if (!showBuff.toString().contains(".")){
                    showBuff.append(".");
                }
                view.setText(showBuff.toString());
                break;
            case R.id.button_Equal:
                break;
        }
    }

}
