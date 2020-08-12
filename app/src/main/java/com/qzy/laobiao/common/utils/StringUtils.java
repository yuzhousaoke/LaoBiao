package com.qzy.laobiao.common.utils;

import android.text.TextUtils;

/**
 * artifact  String工具管理类
 */
public class StringUtils {


    /**
     * 字符串是否为空，null也视为空
     */
    public static boolean isEmpty(String string) {
        return null == string || "".equals(string.replace(" ", "")) || "null".equals(string.trim());
    }

    /**
     * 字符串长度
     */
    public static int length(CharSequence str) {
        return str == null ? 0 : str.length();
    }


    /**
     * 格式化为两位小数
     *
     * @param num
     * @return
     */
    public static String formatDouble(double num) {
        java.text.DecimalFormat df = new java.text.DecimalFormat("#0.00");
        return new java.math.BigDecimal(df.format(num)).stripTrailingZeros().toPlainString();
    }

    /**
     * 格式化为0小数
     *
     * @param num
     * @return
     */
    public static String formatDoubleNo(double num) {
        java.text.DecimalFormat df = new java.text.DecimalFormat("#0");
        return df.format(num);
    }


    /**
     * 格式化为一位小数
     *
     * @param num
     * @return
     */
    public static String formatDouble2(double num) {
        java.text.DecimalFormat df = new java.text.DecimalFormat("#0.0");
        return new java.math.BigDecimal(df.format(num)).stripTrailingZeros().toPlainString();
    }


    /**
     * 隐藏用户名中间三位
     * 13888888888  ---> 138 **** 8888
     *
     * @param text
     * @return
     */
    public static String hideUserPhone(String text) {
        if (TextUtils.isEmpty(text)) {
            return "";
        }
        if (text.length() < 9) {
            return text;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(text.substring(0, 3));
        sb.append(" **** ");
        sb.append(text.substring(7));
        return sb.toString();
    }

    /**
     * 隐藏用户名中间三位
     * 13888888888  ---> 138****8888
     *
     * @param text
     * @return
     */
    public static String hideNoUserPhone(String text) {
        if (TextUtils.isEmpty(text)) {
            return "";
        }
        if (text.length() < 9) {
            return text;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(text.substring(0, 3));
        sb.append("****");
        sb.append(text.substring(7));
        return sb.toString();
    }


    /**
     * 字符串中间添加空格
     * 13888888888  ---> 138****8888
     *
     * @param replace 文本内容
     * @return
     */
    public static String setFileAddSpace(String replace) {
        String regex = "(.{4})";
        replace = replace.replaceAll(regex, "$1\t");
        return replace;
    }

    /**
     * 根据.截取字符串
     */
    public static String[] splitString(String args) {
        if (!isEmpty(args)) {
            return args.split("\\.");
        }
        return null;
    }

    /**
     * 去除空格，全角和半角空格
     *
     * @param str String
     * @return String
     */
    public static String trim(String str) {
        return str.replaceAll("　", "").replace(" ", "");
    }


    /**
     * 去掉小数位后的0
     *
     * @param o Object
     * @return String
     */
    public static String noZero(Object o) {
        String str = o == null ? "" : o.toString();
        if (!TextUtils.isEmpty(str) && str.indexOf(".") > 0) {
            return str.replaceAll("0+?$", "")//去掉后面无用的零
                    .replaceAll("[.]$", "");//如小数点后面全是零则去掉小数点
        }
        return str;
    }

}
