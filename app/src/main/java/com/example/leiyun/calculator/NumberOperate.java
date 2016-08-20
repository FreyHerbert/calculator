package com.example.leiyun.calculator;

import android.util.Log;

/**
 * Created by LeiYun on 2016/8/20 0020.
 */
public class NumberOperate {

    private double doubleNumber;

    public NumberOperate(){
      doubleNumber = 0;
    }

    public String symbolTranslate(String s){//进行相反数的转换
        double oppositeNumber = 0 - Double.parseDouble(s);
        String number = String.valueOf(oppositeNumber);
        return dropTail(number);
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
