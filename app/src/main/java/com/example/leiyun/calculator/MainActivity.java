package com.example.leiyun.calculator;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import java.util.LinkedList;

/**
 * Created by LeiYun on 2016/8/16 0016.
 */
public class MainActivity extends Activity implements View.OnClickListener {
    private TextView view;
    private Button drop, symbol, percent, division;
    private Button seven, eight, nine, multiply;
    private Button four, five, six, minus;
    private Button one, two, three, add;
    private Button zero, point, equal;
    private NumberOperate numberOperate = new NumberOperate();
    private StringBuilder showBuff = new StringBuilder(); //用于数字连续输入时进行缓冲
    private LinkedList<String> numberList = new LinkedList<String>(); //数字栈
    private LinkedList<Integer> weight = new LinkedList<Integer>(); //符号权限栈
    private LinkedList<String> operateSymbol = new LinkedList<String>(); //符号栈
    private int clear = 0;
    private int signal = 1;


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
        switch (v.getId()) {
            case R.id.button_AC: { //清空
                showBuff.setLength(0);
                view.setText("0");
                clearStack();
                clear = 0;
                signal = 1;
                break;
            }

            case R.id.button_Symbol: { //相反数
                if (showBuff.length() != 0) {
                    String s = numberOperate.
                            symbolTranslate(showBuff.toString());
                    showBuff.setLength(0);
                    showBuff.append(s);
                    view.setText(showBuff.toString());
                }
                break;
            }

            case R.id.button_Percent: { //百分比
                break;
            }

            case R.id.button_Division: { // 除法运算

                if (signal == 1) { //检查是否是第一次按下去
                    if (weight.size() == 0 ||
                            weight.getFirst() < NumberOperate.DIVISION) {
                        inStack(NumberOperate.DIVISION, "division");
                        showBuff.setLength(0);
                    } else {
                        String result = view.getText().toString();
                        numberList.addFirst(result);
                        result = calculated();
                        view.setText(result);
                        outStack();
                        if (result.equals("Error")) {
                            showBuff.setLength(0);
                            clearStack();
                            clear = 0;
                            break;
                        }
                        inStack(NumberOperate.DIVISION, "division", result);
                        showBuff.setLength(0);
                    }
                    division.setBackgroundResource(R.drawable.pressed_one);
                    signal = 0;
                } else { //重复摁的时候
                    if (!weight.isEmpty()) {
                        weight.removeFirst();
                        operateSymbol.removeFirst();
                    } else {
                        weight.addFirst(NumberOperate.DIVISION);
                        operateSymbol.addFirst("division");
                    }
                }
                break;
            }


            case R.id.button_Seven: { // 数字7
                showBuff.append("7");
                view.setText(showBuff.toString());
                clear = 1;
                signal = 1;
                break;
            }
            case R.id.button_Eight: { // 数字8
                showBuff.append("8");
                view.setText(showBuff.toString());
                clear = 1;
                signal = 1;
                break;
            }

            case R.id.button_Nine: { // 数字9
                showBuff.append("9");
                view.setText(showBuff.toString());
                clear = 1;
                signal = 1;
                break;
            }

            case R.id.button_Multiply: { // 乘法运算
                if (weight.size() == 0 ||
                        weight.getFirst() < NumberOperate.MULTIPLY) {
                    inStack(NumberOperate.MULTIPLY, "multiply");
                    showBuff.setLength(0);
                } else {
                    do {
                        String result = showBuff.toString();
                        numberList.addFirst(result);
                        result = calculated();
                        view.setText(result);
                        outStack();
                        inStack(NumberOperate.MULTIPLY, "multiply", result);
                        showBuff.setLength(0);
                    } while (weight.getFirst() < NumberOperate.MULTIPLY);
                }
                break;
            }


            case R.id.button_Four: { // 数字4
                showBuff.append("4");
                view.setText(showBuff.toString());
                clear = 1;
                signal = 1;
                break;
            }

            case R.id.button_Five: { // 数字5
                showBuff.append("5");
                view.setText(showBuff.toString());
                clear = 1;
                signal = 1;
                break;
            }

            case R.id.button_Six: { // 数字6
                showBuff.append("6");
                view.setText(showBuff.toString());
                clear = 1;
                signal = 1;
                break;
            }

            case R.id.button_Minus: { //减法运算

                if (signal == 1) { //检查是否是第一次按下去
                    if (weight.size() == 0 ||
                            weight.getFirst() < NumberOperate.DIVISION) {
                        inStack(NumberOperate.MINUS, "minus");
                        showBuff.setLength(0);
                    } else {
                        String result = view.getText().toString();
                        numberList.addFirst(result);
                        result = calculated();
                        view.setText(result);
                        outStack();
                        if (result.equals("Error")) {
                            showBuff.setLength(0);
                            clearStack();
                            clear = 0;
                            break;
                        }
                        inStack(NumberOperate.MINUS, "minus", result);
                        showBuff.setLength(0);
                    }
                    minus.setBackgroundResource(R.drawable.pressed_one);
                    signal = 0;
                } else { //重复摁的时候
                    if (!weight.isEmpty()) {
                        weight.removeFirst();
                        operateSymbol.removeFirst();
                    } else {
                        weight.addFirst(NumberOperate.MINUS);
                        operateSymbol.addFirst("minus");
                    }
                }
                break;
            }


            case R.id.button_One: { // 数字1
                showBuff.append("1");
                view.setText(showBuff.toString());
                clear = 1;
                signal = 1;
                break;
            }

            case R.id.button_Two: { // 数字2
                showBuff.append("2");
                view.setText(showBuff.toString());
                clear = 1;
                signal = 1;
                break;
            }

            case R.id.button_Three: { // 数字3
                showBuff.append("3");
                view.setText(showBuff.toString());
                clear = 1;
                signal = 1;
                break;
            }

            case R.id.button_Add: { //加法运算
                if (weight.size() == 0 ||
                        weight.getFirst() < NumberOperate.ADD) {
                    inStack(NumberOperate.ADD, "add");
                    showBuff.setLength(0);
                } else {
                    String result = showBuff.toString();
                    numberList.addFirst(result);
                    result = calculated();
                    view.setText(result);
                    outStack();
                    inStack(NumberOperate.ADD, "add", result);
                    showBuff.setLength(0);
                }
                break;
            }


            case R.id.button_Zero: { // 数字0
                if (view.getText().charAt(0) == '0')
                    view.setText("0");
                else {
                    showBuff.append("0");
                    view.setText(showBuff.toString());
                }
                signal = 1;
                break;
            }

            case R.id.button_Point: { // 点
                if (showBuff.length() == 0) {
                    showBuff.append("0.");
                } else if (!showBuff.toString().contains(".")) {
                    showBuff.append(".");
                }
                view.setText(showBuff.toString());
                clear = 1;
                break;
            }

            case R.id.button_Equal: { // 等于
                String result = showBuff.toString();
                while (!weight.isEmpty()) {
                    numberList.addFirst(result);
                    result = calculated();
                    outStack();
                }
                numberList.addFirst(result);
                view.setText(numberList.getFirst());
                break;
            }
        }

        if (clear == 0)
            drop.setText("AC");
        else
            drop.setText("C");

        if (signal == 1) {
            division.setBackgroundResource(R.drawable.shape_three);
            minus.setBackgroundResource(R.drawable.shape_three);
        }
    }

    /**
     * 本函数将使用operateSymbol栈中第一个弹出的运算符为条件进行数学运算
     * @return 返回运算结果
     */
    private String calculated() {
        if (numberList.size() >= 2) { //保证运算时有两个数在数字栈中
            double number1 = Double.parseDouble(numberList.getFirst());
            numberList.removeFirst();
            double number2 = Double.parseDouble(numberList.getFirst());
            double number3 = 0;
            switch (operateSymbol.getFirst()) {
                case "add":
                    number3 = number2 + number1;
                    break;
                case "minus":
                    number3 = number2 - number1;
                    break;
                case "multiply":
                    number3 = number2 * number1;
                    break;
                case "division":
                    if (number1 == 0)
                        return "Error";
                    number3 = number2 / number1;
                    break;
            }
            return numberOperate.dropTail(String.valueOf(number3));
        } else {
            return "0";
        }
    }

    /**
     * 本函数用于清空栈
     */
    private void clearStack() {
        if (!operateSymbol.isEmpty())
            operateSymbol.clear();
        if (!weight.isEmpty())
            weight.clear();
        if (!numberList.isEmpty())
            numberList.clear();
    }

    /**
     * 本函数是出栈用的
     */
    private void outStack() {
        if (!operateSymbol.isEmpty())
            operateSymbol.removeFirst();
        if (!weight.isEmpty())
            weight.removeFirst();
        if (!numberList.isEmpty())
            numberList.removeFirst();
    }

    /**
     * 本函数将参数压入对应的栈中
     * @param model 运算符的权限
     * @param symbol 运算符注明运算时需要
     * @param number 运算的数字
     */
    private void inStack(int model, String symbol, String number) {
        weight.addFirst(model);
        operateSymbol.addFirst(symbol);
        numberList.addFirst(number);
    }

    private void inStack(int model, String symbol) {
        weight.addFirst(model);
        operateSymbol.addFirst(symbol);
        numberList.addFirst(view.getText().toString());
    }
}
