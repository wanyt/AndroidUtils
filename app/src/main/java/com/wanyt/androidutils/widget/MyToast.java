package com.wanyt.androidutils.widget;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.wanyt.androidutils.R;
import com.wanyt.androidutils.utils.UtilsString;

/**
 * Created on 2016/11/6 15:03
 * <p>
 * author wang
 * <p>
 * Description:
 * <p>
 * Remarks: 自定义Toast
 */
public class MyToast {

    public static Toast toast;

    /**
     * MODE: Toast.LENGTH_SHORT
     *
     * @param context Context
     * @param strId   String Resources
     */
    public static void show(Context context, int strId) {
        if (context != null) {
            showShortToast(context, context.getResources().getString(strId));
        }
    }

    /**
     * MODE: Toast.LENGTH_LONG
     *
     * @param context Context
     * @param strId   String Resources
     */
    public static void showLong(Context context, int strId) {
        if (context != null) {
            showLongToast(context, context.getResources().getString(strId));
        }
    }

    /**
     * MODE: Toast.LENGTH_SHORT
     *
     * @param context Context
     * @param text    String
     */
    public static void show(Context context, String text) {
        if (context != null) {
            showShortToast(context, text);
        }
    }

    /**
     * MODE: Toast.LENGTH_LONG
     *
     * @param context Context
     * @param text    String
     */
    public static void showLong(Context context, String text) {
        if (context != null) {
            showLongToast(context, text);
        }
    }

    public static void dismiss() {
        if (toast != null) {
            toast.cancel();
        }
    }

    private static void showShortToast(Context context, String string) {
        showToast(context, string, Toast.LENGTH_SHORT);
    }

    private static void showLongToast(Context context, String string) {
        showToast(context, string, Toast.LENGTH_LONG);
    }

    /**
     * The primary method for customizing Toast
     *
     * @param context    Context
     * @param string     Content
     * @param lengthLong duration
     */
    private static void showToast(Context context, String string, int lengthLong) {
        if (context == null || UtilsString.isEmpty(string)) {
            return;
        }

        if (toast == null) {
            toast = new Toast(context instanceof Activity ? context.getApplicationContext() : context);
        }

        View view = LayoutInflater.from(context).inflate(R.layout.layout_toast, null);
        TextView txt = (TextView) view.findViewById(R.id.text_toast);

        txt.setText(string);
        toast.setView(view);
        toast.setDuration(lengthLong);
        toast.show();
    }

}
