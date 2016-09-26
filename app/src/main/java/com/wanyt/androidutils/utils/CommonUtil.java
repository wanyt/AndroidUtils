package com.wanyt.androidutils.utils;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;

import java.io.File;

/**
 * Created on 2016/9/24 16:01
 * <p>
 * author wang
 * <p>
 * Description:
 */

public class CommonUtil {

    /**
     * 安装APK
     * 未测试通过
     *
     * @param context
     * @param file
     */
    public static void installApk(Context context, File file) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setType("application/vnd.android.package-archive");
        intent.setDataAndType(Uri.fromFile(file),
                "application/vnd.android.package-archive");
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    /**
     * 主动退回到home，后台运行
     *
     * @param context
     */
    public static void backHome(Context context) {
        Intent mHomeIntent = new Intent(Intent.ACTION_MAIN);
        mHomeIntent.addCategory(Intent.CATEGORY_HOME);
        mHomeIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
        context.startActivity(mHomeIntent);
    }

    /**
     * 获取状态栏高度
     * 已测试
     *
     * @param context
     * @return
     */
    public static int getStatusBarHeight(Context context) {
        int result = 0;
        Resources resources = context.getResources();
        int resourceId = resources.getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = resources.getDimensionPixelSize(resourceId);
        }
        return result;
    }

//    public static void sendNotification(Context context, String title,
//                                        String message, Bundle extras) {
//        Intent mIntent = new Intent(context, FragmentTabsActivity.class);
//        mIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//        mIntent.putExtras(extras);
//
//        int requestCode = (int) System.currentTimeMillis();
//
//        PendingIntent mContentIntent = PendingIntent.getActivity(context,
//                requestCode, mIntent, 0);
//
//        Notification mNotification = new NotificationCompat.Builder(context)
//                .setContentTitle(title).setSmallIcon(R.drawable.app_icon)
//                .setContentIntent(mContentIntent).setContentText(message)
//                .build();
//        mNotification.flags |= Notification.FLAG_AUTO_CANCEL;
//        mNotification.defaults = Notification.DEFAULT_ALL;
//
//        NotificationManager mNotificationManager = (NotificationManager) context
//                .getSystemService(Context.NOTIFICATION_SERVICE);
//
//        mNotificationManager.notify(requestCode, mNotification);
//    }

}
