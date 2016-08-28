package com.example.leiyun.calculator;

import android.util.Log;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by LeiYun on 2016/8/20 0020.
 */
public class NumberOperate {

    public static int DIVISION = 2;
    public static int MULTIPLY = 2;
    public static int MINUS = 1;
    public static int ADD = 1;
    public static int EQUAL = 3;
    public static int PERCENT = 0;


    private double doubleNumber;
    private List<String> numberList = new LinkedList<String>(); //数字栈
    private List<String> operateSymbol = new LinkedList<String>(); //符号栈

    public NumberOperate(){
      doubleNumber = 0;
    }

    public String symbolTranslate(String s){//进行相反数的转换
        if (s.charAt(0) == '-') {
            return s.substring(1);
        }else
            return "-" + s;
    }

    public String dropTail(String s) {
        String s1 = s;
        String[] array = s1.split("[.]");//将字符以点分开，这样会得到两个不含点符号的字符串
        if (array[1].equals("0"))  // 因为根据数学上的性质小数点后只有0的数可以表示成一个整数
            return array[0];
        else
            return s;
    }


}
