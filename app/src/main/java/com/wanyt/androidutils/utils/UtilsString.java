package com.wanyt.androidutils.utils;

import android.text.TextUtils;
import android.util.Patterns;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created on 2016/9/24 10:17
 * <p>
 * author wang
 * <p>
 * Description: 字符串相关的工具类
 */
public class UtilsString {

    /**
     * 检测文本是否为空
     *
     * @param text
     * @return
     */
    public static boolean isEmpty(String text) {
        if (!TextUtils.isEmpty(text)) {
            if (text.trim().length() > 0) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * 检测邮箱地址是否有效
     *
     * @param email 输入的邮箱地址
     * @return 有效地址返回true，否则false
     */
    public static boolean isEmailIdValid(String email) {
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = email;

        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);

        if (matcher.matches())
            return true;
        else
            return false;
    }

    public static boolean isWebsiteUrlValid(String url) {
        return Patterns.WEB_URL.matcher(url).matches();
    }

    /**
     * 检测字符串是否包含汉字
     *
     * @param sequence
     * @return
     */
    public static boolean isContainChinese(String sequence) {
        final String format = "[\\u4E00-\\u9FA5\\uF900-\\uFA2D]";
        boolean result = false;
        Pattern pattern = Pattern.compile(format);
        Matcher matcher = pattern.matcher(sequence);
        result = matcher.find();
        return result;
    }



}
