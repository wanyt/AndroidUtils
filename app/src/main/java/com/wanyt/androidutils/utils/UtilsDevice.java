package com.wanyt.androidutils.utils;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;

/**
 * Created on 2016/9/24 14:04
 * <p>
 * author wang
 * <p>
 * Description:获取设备信息相关的工具类
 */
public class UtilsDevice {

    /**
     * 获取设备的IMEI
     * 需要权限
     * <uses-permission android:name="android.permission.READ_PHONE_STATE" />
     * 已测试
     *
     * @param context
     * @return IMEI
     */
    public static String getDeviceIMEI(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context
                .getSystemService(Context.TELEPHONY_SERVICE);
        return telephonyManager.getDeviceId();
    }

    /**
     * 获取设备的mac地址
     * 需要权限
     * <uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
     * 已测试
     *
     * @param context
     * @return
     */
    public static String getMacAddress(Context context) {
        String macAddress = null;
        WifiManager wifi = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        WifiInfo info = wifi.getConnectionInfo();
        macAddress = info.getMacAddress();
        if (null == macAddress) {
            return "";
        }
        macAddress = macAddress.replace(":", "");
        return macAddress;
    }

    /**
     *
     */

    /**
     * 仅当用户已在网络注册时有效, CDMA 可能会无效
     * 中国移动：46000 46002, 中国联通：46001,中国电信：46003
     * 已测试
     *
     * @param context
     * @return
     */
    public static String getNetworkOperator(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context
                .getSystemService(Context.TELEPHONY_SERVICE);
        return telephonyManager.getNetworkOperator();
    }



}
